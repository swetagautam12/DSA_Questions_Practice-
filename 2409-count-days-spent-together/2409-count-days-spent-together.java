class Solution {
    private static final int[] prefix = new int[12];

    private int present(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        return prefix[month - 1] + day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < 12; i++) {
            prefix[i] = prefix[i - 1] + days[i - 1];
        }

        int start = Math.max(present(arriveAlice), present(arriveBob));
        int end = Math.min(present(leaveAlice), present(leaveBob));

        return Math.max(0, end - start + 1);
    }
}