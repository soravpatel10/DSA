class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        if (original == color) return image;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});

        image[sr][sc] = color;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {

                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < image.length &&
                    nc >= 0 && nc < image[0].length &&
                    image[nr][nc] == original) {

                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}