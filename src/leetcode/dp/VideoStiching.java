package leetcode.dp;

public class VideoStiching {
    public int videoStitching(int[][] clips, int T) {

        int len = Integer.MAX_VALUE;
        for (int i = 0; i < clips.length; i++) {
            int[] clip = clips[i];
            if (clip[1] >= T) {
                len = Math.min(len, helper(clip, clips));
            }
        }

        return len == Integer.MAX_VALUE ? -1 : len;

    }

    private int helper(int[] clip, int[][] clips) {

        if (clip[0] == 0) return 1;
        int len = Integer.MAX_VALUE;
        int[] interval = findPrevIntervals(clip, clips);
        if (interval == null) return len;
        int val = helper(interval, clips);
        if (val != Integer.MAX_VALUE) {
            len = Math.min(len, 1 + val);
        }

        return len;
    }


    private int[] findPrevIntervals(int[] currClip, int[][] clips) {
        int[] interval = null;
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] < currClip[0] && clips[i][1] >= currClip[0] && currClip != clips[i]) {
                if (interval == null) {
                    interval = clips[i];
                } else if (clips[i][0] < interval[0]) {
                    interval = clips[i];
                }
            }
        }

        return interval;
    }

    public static void main(String[] args) {
        System.out.println(new VideoStiching().videoStitching(new int[][]{{0, 2}, {4, 8},}, 5));
    }
}
