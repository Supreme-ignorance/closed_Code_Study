import java.util.*;

class Solution {
	public static void main(String[] args) {
		solution(new long[] {95, 63, 111});
	}
	
	static List<Long> ll;
    static long trueSize;
    static boolean isgoal;
    static long[] answer;
    
    public static long[] solution(long[] numbers) {
    	answer = new long
    			[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
        	ll = new LinkedList<>();
        	
        	makeBt(i, numbers);
        	
        	System.out.println(ll);
        	
        	if (ll.get(ll.size() / 2) == 0) {
        		answer[i] = 0;
        		continue;
        	}
        	
        	isgoal = true;
        	checkBt(i, true, 0, ll.size() - 1);
        	
        	if (isgoal) answer[i] = 1;
        	else answer[i] = 0;
        	
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
    
    private static void checkBt(int i, boolean isOne, long start, long end) {
    	if (start == end) {
    		if (ll.get((int) start) == 1) {
    			if (!isOne) {
        			isgoal = false;
        			return;
        		}
    		}
    		return;
    	}
    	
    	long mid = (start + end) / 2;
    	System.out.println(isOne + " " + ll.get((int) mid));
    	
    	if (ll.get((int) mid) == 0) {
    		checkBt(i, false, start, mid - 1);
    		checkBt(i, false, mid + 1, end);
    	} else if (ll.get((int) mid) == 1) {
    		if (!isOne) {
    			isgoal = false;
    			return;
    		}
    		checkBt(i, true, start, mid - 1);
    		checkBt(i, true, mid + 1, end);
    	}
	}

	static void makeBt(int idx, long[] numbers) {
    	int cnt = 0;
    	long temp = 1;
    	while (true) {
    		if ((numbers[idx] & temp) != 0) {
    			ll.add(cnt, (long) 1);
    		} else {
    			ll.add(cnt, (long) 0);
    		}
    		temp = temp << 1;
    		cnt++;
    		if (temp > numbers[idx]) break;
    	}
    	
    	trueSize = 1;
    	long up = 1;
        while (ll.size() > trueSize) {
        	up = up << 1;
            trueSize += up;
        }
    	
        while (trueSize != ll.size()) {
			ll.add(cnt, (long) 0);
        }
	}
}