package NowCoder.class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 安排会议室的使用，会议室不能同时容纳2个宣讲，给你每个项目的开始和结束时间，安排宣讲日程，要求会议室进行的宣讲的场次最多
 * 贪心策略：
 * 1.如果安排最早的开始，可能这个最早的占一整天，不合适
 * 2.如果选择时间最短的，但是这个时间最短的可能占用了2个宣讲的时间，不合适
 * 3.选择结束时间最早的，然后将这个时间的结束时间当做当前时间，选择那些开始时间在当前时间之后并且结束时间最早的宣讲会
 *
 * 总结：对于贪心的策略，多积累，多总结
 *
 */
public class BestArrange {
    public static class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(int[] start, int[] end) {
        int n = start.length;
        Program[] programs = new Program[n];
        for (int i = 0; i < n; i++) {
            programs[i] = new Program(start[i], end[i]);
        }
        // 将结束时间早的排在前面
        Arrays.sort(programs, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });
        int res = 1;
        int cur = programs[0].end;
        for (int i = 1; i < programs.length; i++) {
            if (programs[i].start >= cur) {
                res++;
                cur = programs[i].end;
            }
        }
        return res;
    }
}
