/*    function turnsMatch(teamsNum) {
      var teams = new Array(); // 当teamsNum为偶数时，teams[0]不保存对象，奇数时保存对象0，轮空。
      var turnsNum = 0,
          matchesPerTurns = teamsNum / 2;
      if (teamsNum % 2 == 0) {
        turnsNum = teamsNum - 1;

        // alert(teamsNum);

        for (var i=0; i < teamsNum + 1; i++) {
          teams.push(i);
        }

        // alert(teams);
        for(var t=1; t<turnsNum+1; t++) {
          document.write("第" + t + "轮");
          for(var j=1; j < matchesPerTurns + 1 ; j++) {

            document.write("<br/>");
            document.write(teams[j] + " VS " + teams[(teamsNum+1)-j]);
          }
          document.write("<br/>");
          document.write("<br/>");
          
          for(var j=1; j < teamsNum + 1 ; j++) {
            var tmp = teams[j];
            teams[j] = teams[teamsNum];
            teams[teamsNum] = tmp
          }           
        }

      }
    }*/


public class Match {
	public static void main(String[] args) {
		
	}
	
	public static void match(int teamsNum) {
	    // function turnsMatch(teamsNum) {
/*	    int teams = new int[teamsNum];
		var teams = new Array(); // 当teamsNum为偶数时，teams[0]不保存对象，奇数时保存对象0，轮空。
	        var turnsNum = 0,
	            matchesPerTurns = teamsNum / 2;
	        if (teamsNum % 2 == 0) {
	          turnsNum = teamsNum - 1;

	          // alert(teamsNum);

	          for (var i=0; i < teamsNum + 1; i++) {
	            teams.push(i);
	          }

	          // alert(teams);
	          for(var t=1; t<turnsNum+1; t++) {
	            document.write("第" + t + "轮");
	            for(var j=1; j < matchesPerTurns + 1 ; j++) {

	              document.write("<br/>");
	              document.write(teams[j] + " VS " + teams[(teamsNum+1)-j]);
	            }
	            document.write("<br/>");
	            document.write("<br/>");
	            
	            for(var j=1; j < teamsNum + 1 ; j++) {
	              var tmp = teams[j];
	              teams[j] = teams[teamsNum];
	              teams[teamsNum] = tmp
	            }           
	          }

	        }
	      }*/
	}
}
