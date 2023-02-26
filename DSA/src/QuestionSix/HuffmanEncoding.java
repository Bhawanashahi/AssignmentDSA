package QuestionSix;//question no six(a)
//Ans

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class HuffmanEncoding {
    public static void main(String[] args) {
        String text = "Bhawana";
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new MyComparator());

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            HuffmanNode node = new HuffmanNode();
            node.c = entry.getKey();
            node.data = entry.getValue();
            node.left = null;
            node.right = null;
            pq.add(node);
        }

        while (pq.size() > 1) {
            HuffmanNode x = pq.peek();
            pq.poll();
            HuffmanNode y = pq.peek();
            pq.poll();
            HuffmanNode z = new HuffmanNode();
            z.data = x.data + y.data;
            z.c = '-';
            z.left = x;
            z.right = y;
            pq.add(z);
        }

        HuffmanNode root = pq.peek();

        Map<Character, String> codes = new HashMap<>();
        encode(root, "", codes);

        System.out.println("Original text: " + text);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            sb.append(codes.get(c));
        }
        String encodedText = sb.toString();
        System.out.println("Encoded text: " + encodedText);

        String decodedText = decode(root, encodedText);
        System.out.println("Decoded text: " + decodedText);
    }

    public static void encode(HuffmanNode root, String str, Map<Character, String> codes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            codes.put(root.c, str);
        }
        encode(root.left, str + "0", codes);
        encode(root.right, str + "1", codes);
    }

    public static String decode(HuffmanNode root, String str) {
        StringBuilder sb = new StringBuilder();
        HuffmanNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
            if (cur.left == null && cur.right == null) {
                sb.append(cur.c);
                cur = root;
            }
        }
        return sb.toString();
    }
}
