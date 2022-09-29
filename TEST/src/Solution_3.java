class Solution_3 {
	
	static int emoticonNum;
	static int userNum;
	static int[] discountRates; // 0 은 10% ~~~
	static int maxUserNum = Integer.MIN_VALUE;
	static int maxsales = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		solution(new int[][] {{40, 10000}, {25, 10000}}, new int[] {7000, 9000});
	}
	
    public static int[] solution(int[][] users, int[] emoticons) {
    	emoticonNum = emoticons.length;
    	userNum = users.length;
    	discountRates = new int[emoticonNum];
        
        discountList(users, emoticons, 0);
        
        System.out.println(maxUserNum + " " + maxsales);
        return new int[] {maxUserNum, maxsales};
    }
    
    // idx번째의 할인률 결정
	static void discountList(int[][] users, int[] emoticons, int idx) {
		if (idx == emoticonNum) {
			checkUsers(users, emoticons);
			return;
		}
		
		discountRates[idx] = 10;
		discountList(users, emoticons, idx + 1);
		
		discountRates[idx] = 20;
		discountList(users, emoticons, idx + 1);
		
		discountRates[idx] = 30;
		discountList(users, emoticons, idx + 1);
		
		discountRates[idx] = 40;
		discountList(users, emoticons, idx + 1);
	}
	
	static void checkUsers(int[][] users, int[] emoticons) {
		int UserNum = 0;
		int sales = 0;
		
		for (int i = 0; i < userNum; i ++) {
			int buy = 0;
			boolean isSign = false;
			
			if (userNum - i + UserNum < maxUserNum) return;
			
			for (int j = 0; j < emoticonNum; j++) {
				if (users[i][0] <= discountRates[j]) {
					buy += emoticons[j] * (100 - discountRates[j]) / 100;
				}
			}
			
			
			if (buy >= users[i][1]) {
				isSign = true;
			}
			
			if (isSign) UserNum++;
			else sales += buy;
		}
		
		if (maxUserNum < UserNum) {
			maxUserNum = UserNum;
			maxsales = sales;
		} else if (maxUserNum == UserNum && maxsales < sales) {
			maxsales = sales;
		}
	}
}
















