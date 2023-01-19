
public abstract class Game {
	private static int turnNum;
	private static int actionNum;
	private static int maxActions = 5;
	private static int maxTurns = 8;
	
	Game(){
		
	}
	
	public static void startGame()
	{
		actionNum = 1;
		do
		{
			if(turnNum == maxTurns - 1)
			{
				actionNum = -1;
			}
			while(actionNum < maxActions)
			{
				System.out.print(" ");
			}
			actionNum = 0;
			++turnNum;
			
			System.out.print(" ");
		}while(turnNum < maxTurns);
		
	}

	public static void incrActionNum()
	{
		++actionNum;
	}
	public static String getTurnNum()
	{
		int maxActions = 5;
		int offset = turnNum + 1;
		int actionsLeft = maxActions - actionNum + 1;
		
		if(turnNum == maxTurns - 1)
		{
			actionsLeft = maxActions - actionNum;
		}
		String turnString = " Week " + String.valueOf(offset) + "  |  Actions Left: " + String.valueOf(actionsLeft);
		return turnString;
	}
	public static int getWeekNum()
	{
		int offset = turnNum + 1;
		return offset;
	}
	public static int getActionNum()
	{
		int maxActions = 5;
		int actionsLeft = maxActions - actionNum + 1;
		return actionsLeft;
	}

}
