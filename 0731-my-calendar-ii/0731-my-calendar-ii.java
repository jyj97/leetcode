import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {

    private List<int[]> calendar;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // 먼저, 겹치는 부분이 있는지 확인
        // 이미 두번 겹쳐져 있는 부분이 overlaps에 있고
        // 지금 추가로 또 겹쳐지려하면 바로 손절
        for (int[] overlap : overlaps) {
            int o_start = overlap[0], o_end = overlap[1];
            if (start < o_end && end > o_start) {
                return false;
            }
        }

        // 새로 추가할 이벤트가 겹치는 경우를 overlaps에 추가
        for (int[] event : calendar) {
            int c_start = event[0], c_end = event[1];
            if (start < c_end && end > c_start) {
                overlaps.add(new int[]{Math.max(start, c_start), Math.min(end, c_end)});
            }
        }

        // 달력에 이벤트를 추가
        calendar.add(new int[]{start, end});
        return true;
    }
}