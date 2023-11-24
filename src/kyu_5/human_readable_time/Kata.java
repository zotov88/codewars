package kyu_5.human_readable_time;

public class Kata {

    public static void main(String[] args) {
        int seconds = 359999;
        System.out.println(makeReadable(seconds));
    }

    public static String makeReadable(int seconds) {
        ReadableTime time = new ReadableTime(seconds);
        return time.toString();
    }

    static class ReadableTime {

        private int hour;
        private int minute;
        private int second;
        private int secondsToTime;

        public ReadableTime(int secondsToTime) {
            this.secondsToTime = secondsToTime;
            parseSecondsToTime();
        }

        public void parseSecondsToTime() {
            getHours();
            getMinutes();
            getSeconds();
        }

        private void getHours() {
            hour = secondsToTime / 60 / 60;
            secondsToTime -= hour * 60 * 60;
        }

        private void getMinutes() {
            minute = secondsToTime / 60;
            secondsToTime -= minute * 60;
        }

        private void getSeconds() {
            second = secondsToTime;
        }

        private String numToString(int num) {
            return num == 0 ? "00"
                    : num < 10 ? "0" + num
                    : Integer.toString(num);
        }

        @Override
        public String toString() {
            return numToString(hour) + ":" + numToString(minute) + ":" + numToString(second);
        }
    }
}
