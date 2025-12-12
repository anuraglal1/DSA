package Graph;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int l = word.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = check(board, word, i, j, 0, m, n, l);
                    if (ans) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean check(char[][]board, String word, int i, int j,
                         int k, int m, int n, int l) {
        if (k == l) {
            return true;
        }

        if (!isValid(i, j, k, m, n, l, board, word)) {
            return false;
        }

        board[i][j] = '#';

        boolean x = check(board, word, i+1, j, k+1, m, n, l);
        boolean y = check(board, word, i-1, j, k+1, m, n, l);
        boolean z = check(board, word, i, j+1, k+1, m, n, l);
        boolean t = check(board, word, i, j-1, k+1, m, n, l);

        if (x || y || z || t) {
            return true;
        }

        board[i][j] = word.charAt(k);

        return false;



    }

    public static boolean isValid(int i, int j, int k, int m, int n, int l, char[][] board,
                           String word) {
        return i >= 0 && j >= 0 && i < m && j < n &&
                board[i][j] == word.charAt(k);
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        if (exist(board, word)) {
            System.out.println("Yeah, the word exists 😊");
        } else {
            System.out.println("No, the word doesn't exists 😢");
        }
    }
}
