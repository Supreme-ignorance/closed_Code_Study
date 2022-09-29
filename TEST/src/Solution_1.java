import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution_1 {
	
	static int inputTermsSize;
	static int inputPrivaciesSize;
	static Map<String, Integer> Terms = new HashMap<>();
	static List<Integer> ans = new ArrayList<>();
	static int[] answer;
	static StringTokenizer st;
	
	public static void main(String[] args) throws ParseException {
		String[] terms = new String[] {"[A, 1]"};
		String[] privacies = new String[] {"[1, 2022.04.11, A]", "[2, 2022.08.23, A]"};
		String today = "2022.09.24";
		
		solution(today, terms, privacies);
	}
	
    public static int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
    	inputTermsSize = terms.length;
    	inputPrivaciesSize = privacies.length;
    	
    	termsList(terms);
    	
    	privaciesList(privacies, today);
    	
    	answer = new int[ans.size()];
    	
    	for (int i = 0; i < ans.size(); i++) {
    		answer[i] = ans.get(i);
    		System.out.println(answer[i]);
    	}

        return answer;
    }

	private static void privaciesList(String[] privacies, String today) throws ParseException {
		
		for (int idx = 0; idx < inputPrivaciesSize; idx++) {
			String input = privacies[idx].substring(1, privacies[idx].length() - 1);
        	st = new StringTokenizer(input, ", ");
        	
        	int i = Integer.valueOf(st.nextToken());
        	String startDay = st.nextToken();
        	String type = st.nextToken();
        	
        	//시작일
        	Date expirDay = new SimpleDateFormat("yyyy.MM.dd").parse(startDay);
        	
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(expirDay);
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
            
            cal.add(Calendar.MONTH, Terms.get(type));
            
            expirDay = new SimpleDateFormat("yyyy.MM.dd").parse(df.format(cal.getTime()));
        	//오늘
        	Date td = new SimpleDateFormat("yyyy.MM.dd").parse(today);
        	
        	long diffSec = (expirDay.getTime() - td.getTime()) / 1000; //초 차이
        	long diffDays = diffSec / (24*60*60); // 양수면 아직 남았다.
        	
        	System.out.println(diffDays);
        	
        	if (diffDays > 0) {
        		ans.add(i);
        	}
        }
		
	}

	private static void termsList(String[] terms) {
		
		for (int idx = 0; idx < inputTermsSize; idx++) {
			String input = terms[idx].substring(1, terms[idx].length() - 1);
        	st = new StringTokenizer(input, ", ");
        	
        	String type = st.nextToken();
        	Integer expirMonth = Integer.valueOf(st.nextToken());
        	
        	Terms.put(type, expirMonth);
        }
		
	}
}