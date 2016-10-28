package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Assignments {

    public static void main(String[] args) {

        // 1
        List<String> nameList = TestData.getAllFruits().stream()
                .filter(f -> f.getCalories() < 100)
                .sorted(Comparator.comparingInt(Fruit::getCalories))
                .map(Fruit::getName).collect(Collectors.toList());

        System.out.println(nameList);

        System.out.println();

        // 2
        Map<String, List<Fruit>> colourList = TestData.getAllFruits().stream()
                .collect(Collectors.groupingBy(Fruit::getColor));
        System.out.println(colourList);

        System.out.println();

        // 3
        List<Fruit> redPrice = TestData.getAllFruits().stream()
                .filter(f -> f.getColor().equals("Red"))
                .sorted(Comparator.comparingInt(Fruit::getPrice))
                .collect(Collectors.toList());

        System.out.println(redPrice);
        System.out.println();

        // 4
        System.out.println("4 assignment");
        Optional<Entry<Integer, Long>> max = TestData.getAllNews().stream()
                .collect(Collectors.groupingBy(News::getNewsId,
                        Collectors.counting()))
                .entrySet().stream()
                .max(new Comparator<Entry<Integer, Long>>() {

                    @Override
                    public int compare(Entry<Integer, Long> o1,
                            Entry<Integer, Long> o2) {
                        // TODO Auto-generated method stub
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });
        System.out.println(max);

        // 5
        System.out.println();
        int totalBudget = TestData.getAllNews().stream().flatMapToInt(t -> {
            int count = 0;
            String[] words = t.getComment().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("budget")) {
                    count++;
                }
            }
            return IntStream.of(count);
        }).sum();

        System.out.println(totalBudget);

        System.out.println();

        // 6
        Map<String, Long> commentByUser = TestData.getAllNews().stream()
                .collect(Collectors.groupingBy(News::getCommentByUser,
                        Collectors.counting()));
        System.out.println(commentByUser);

        System.out.println();

        // 7
        List<Transaction> smallToHigh = TestData.getAllTransactions().stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(smallToHigh);

        // 8
        List<String> cities = TestData.getAllTransactions().stream()
                .map(t -> t.getTrader().getCity()).distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        // 9
        List<Trader> puneTraders = TestData.getAllTransactions().stream()
                .map(t -> t.getTrader()).filter(t -> t.getCity().equals("Pune"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(puneTraders);

        System.out.println();

        // 10
        List<String> traderName = TestData.getAllTransactions().stream()
                .map(t -> t.getTrader())
                .sorted(Comparator.comparing(Trader::getName))
                .map(tr -> tr.getName()).collect(Collectors.toList());
        System.out.println(traderName);

        System.out.println();

        // 11
        Boolean indoreTrader = TestData.getAllTransactions().stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Indore"));
        System.out.println(indoreTrader);

        // 12
        List<Integer> values = TestData.getAllTransactions().stream().map(t -> {
            if (t.getTrader().getCity().equals("Delhi")) {
                return t.getValue();
            }
            return null;
        }).collect(Collectors.toList());
        values.forEach(t -> {
            if (t != null) {
                System.out.println(t);
            }

        });

        System.out.println();

        // 13
        Optional<Integer> maxTran = TestData.getAllTransactions().stream()
                .map(t -> t.getValue()).reduce(Integer::max);
        System.out.println(maxTran);

        // 14
        System.out.println();
        Optional<Transaction> minTran = TestData.getAllTransactions().stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(minTran);

        // 15
        System.out.println();
        Optional<News> maxCommentNews = TestData.getAllNews().stream()
                .max(Comparator.comparing(News::getComment));
        System.out.println(maxCommentNews);

        System.out.println(TestData.getAllNews().stream().collect(Collectors
                .groupingBy(News::getCommentByUser, Collectors.counting())));
    }
}
