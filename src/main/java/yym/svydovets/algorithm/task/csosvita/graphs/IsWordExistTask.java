package yym.svydovets.algorithm.task.csosvita.graphs;

/**
 * {@link yym.svydovets.algorithm.task.matrix.WordSearch}
 */
public class IsWordExistTask {

    public static int isWordExist(Character[][] words, String word) {
        int rows = words.length;
        int cols = words[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(words, i, j, word, 0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean exist(Character[][] words, int row, int col, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= words.length || col >= words[0].length || words[row][col] != word.charAt(idx)) {
            return false;
        }

        char temp = words[row][col];
        words[row][col] = '#';
        boolean exist = exist(words, row+1, col, word, idx + 1)
            || exist(words, row-1, col, word, idx + 1)
            || exist(words, row, col+1, word, idx + 1)
            || exist(words, row, col-1, word, idx + 1);
        words[row][col] = temp;
        return exist;
    }

}
