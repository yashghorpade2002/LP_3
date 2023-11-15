package DAA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Item {
    double weight;
    double value;
    double bound;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }
}

public class knapsack {
    public static double knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
            items[i].bound = (double) values[i] / weights[i];
        }

        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                return Double.compare(item2.bound, item1.bound);
            }
        });

        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                return Double.compare(item2.bound, item1.bound);
            }
        });

        double maxProfit = 0;
        double currentWeight = 0;
        double currentValue = 0;
        double level = -1;

        while (level < n) {
            if (level == n - 1) {
                if (currentWeight + items[(int) level].weight <= capacity) {
                    currentWeight += items[(int) level].weight;
                    currentValue += items[(int) level].value;
                }
                maxProfit = Math.max(maxProfit, currentValue);
                if (!queue.isEmpty()) {
                    Item node = queue.poll();
                    if (node.bound > maxProfit) {
                        level = node.weight;
                        currentWeight = node.weight;
                        currentValue = node.value;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                level++;
                if (currentWeight + items[(int) level].weight <= capacity) {
                    queue.add(new Item(currentWeight + items[(int) level].weight, currentValue + items[(int) level].value));
                }
                queue.add(new Item(currentWeight, currentValue));

                Item nextNode = queue.poll();
                currentWeight = nextNode.weight;
                currentValue = nextNode.value;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        double maxProfit = knapsack(weights, values, capacity);
        System.out.println("Maximum value that can be obtained: " + maxProfit);
    }
}

