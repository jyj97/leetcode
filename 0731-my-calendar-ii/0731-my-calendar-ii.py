class MyCalendarTwo:

    def __init__(self):
        self.calendar = []
        self.overlaps = []

    def book(self, start: int, end: int) -> bool:
        # 먼저, 겹치는 부분이 있는지 확인
        # 이미 두번 겹쳐져 있는 부분이 overlaps에 있고
        # 지금 추가로 또 겹쳐지려하면 바로 손절
        for o_start, o_end in self.overlaps:
            # 네모 박스 두개 그리면 이해될 것임
            if start < o_end and end > o_start:
                return False
        
        # 새로 추가할 이벤트가 겹치는 경우를 overlaps에 추가
        for c_start, c_end in self.calendar:
            if start < c_end and end > c_start:
                # 네모 박스 두개 그리면 이해될 것임 당연히 겹쳐지게 그려야지
                self.overlaps.append((max(start, c_start), min(end, c_end)))
        
        # 달력에 이벤트를 추가
        self.calendar.append((start, end))
        return True