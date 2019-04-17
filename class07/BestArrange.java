package NowCoder.class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * ���Ż����ҵ�ʹ�ã������Ҳ���ͬʱ����2������������ÿ����Ŀ�Ŀ�ʼ�ͽ���ʱ�䣬���������ճ̣�Ҫ������ҽ��е������ĳ������
 * ̰�Ĳ��ԣ�
 * 1.�����������Ŀ�ʼ��������������ռһ���죬������
 * 2.���ѡ��ʱ����̵ģ��������ʱ����̵Ŀ���ռ����2��������ʱ�䣬������
 * 3.ѡ�����ʱ������ģ�Ȼ�����ʱ��Ľ���ʱ�䵱����ǰʱ�䣬ѡ����Щ��ʼʱ���ڵ�ǰʱ��֮���ҽ���ʱ�������������
 *
 * �ܽ᣺����̰�ĵĲ��ԣ�����ۣ����ܽ�
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
        // ������ʱ���������ǰ��
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
