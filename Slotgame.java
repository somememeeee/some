import java.util.*;
public class Slotgame {
    //メソッド説明
    //void beforRun()
    //void run(int a)
    //void MakeSlotVlue()
    //void showSlot()
    //void checkSlotWinValue()
    //void checkCountOf()
    //boolean check()
    //int returnBesideCount()
    //int return VerticalCount
    //int check_beside()
    //int check_vertical()


    int[][] slot ={{0,0,0},{0,0,0},{0,0,0}};
    int[][] slotWinValue ={{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
    int slotWinPlaceOfI=0;
    int slotWinPlaceOfJ=0;
    int check_beside_count=0;
    int check_vertical_count=0;
    int money=0;
    Random rd = new Random();
    Scanner stdIn = new Scanner(System.in);

    /*
    void beforeRun(){
        System.out.println("スロットへようこそ。このスロットは1～7の数字が出る3×3のスロットです");
        System.out.println("何連続で何回遊びますか？");
        System.out.print("連続回数:");
        int inputInt_one=stdIn.nextInt();

        System.out.print("何回遊ぶ？:");
        int inputInt_two=stdIn.nextInt();

        for(int i=0;i<inputInt_two;i++){
            this.run(inputInt_one);
            this.sleepTime();
        }

    }

    */

    public void run(){

        System.out.println("スロットへようこそ。このスロットは1～7の数字が出る3×3のスロットです");
        System.out.println("縦または横に同じ数字が揃うと数字×1000円貰えます");
        System.out.println("また、斜めに同じ数字が揃うと数字×2000円貰えます");
        System.out.print("何回遊びますか？:");
        int inputInt=stdIn.nextInt();

        for(int i=0;i<inputInt;i++){
            this.resetWinValue(slotWinValue);
            this.MakeSlotValue();
            this.checkCountOf();
            this.showSlot();
            System.out.println();
            //this.checkSlotWinValue();
            if(this.returnBesideCount()>0||this.returnVerticalCount()>0){
                for(int k=0;k<slotWinValue[0].length;k++){
                    if(slotWinValue[0][k]>0){
                        money += 1000*slotWinValue[0][k];
                    }
                }

            for(int j=0;j<slotWinValue[1].length;j++){
                if(slotWinValue[1][j]>0){
                    money += 2000*slotWinValue[1][j];
                }
            }
        }
        }
        
        if(money==0){
            System.out.println("ハズレでした");
        }else{
            System.out.println("合計"+money+"円の収益が入りました");
        }
        System.out.println();

    }

    void MakeSlotValue(){
        for(int i=0;i<slot.length;i++){
            for(int j=0;j<slot[i].length;j++){
                slot[i][j] = rd.nextInt(7)+1;
            }
        }
    }

    void showSlot(){
        for(int i=0;i<slot.length;i++){
            for(int j=0;j<slot[i].length;j++){
                System.out.print(slot[i][j]+" ");
            }
            System.out.println();
        }
    }

    void checkSlotWinValue(){
        for(int i=0;i<slotWinValue.length;i++){
            for(int j=0;j<slotWinValue[i].length;j++){
                System.out.print(slotWinValue[i][j]);
            }
            System.out.println();
        }
    }

    void checkCountOf(){
        check_beside_count = check_beside();
        check_vertical_count = check_vertical();
    }

    boolean check(){
        if(check_beside()>=1||check_vertical()>=1){
            //System.out.println("ok");
            return true;
        }else{
            //System.out.println("no");
            return false;
        }
    }

    int returnBesideCount(){
        //System.out.println(check_beside_count);
        return check_beside_count;
    }

    int returnVerticalCount(){
        //System.out.println(check_vertical_count);
        return check_vertical_count;
    }
    
    int check_beside(){
        for(int i=0;i<slot.length;i++){
            if(slot[i][0]==slot[i][1]&&slot[i][0]==slot[i][2]){
                check_beside_count +=1;
                slotWinValue[0][slotWinPlaceOfI] = slot[i][0];
                slotWinPlaceOfI+=1;
            }

            if(slot[0][i]==slot[1][i]&&slot[1][i]==slot[2][i]){
                check_beside_count +=1;
                slotWinValue[0][slotWinPlaceOfI] = slot[0][i];
                slotWinPlaceOfI+=1;
            }
        }
        //System.out.println("check_beside() is now "+check_beside_flag);
        
        return check_beside_count;
    }
    

    int check_vertical(){
        int check_vertical_count=0;

        if(slot[0][0]==slot[1][1]&&slot[1][1]==slot[2][2]){
            check_vertical_count+=1;
            slotWinValue[1][slotWinPlaceOfJ] = slot[1][1];
            slotWinPlaceOfJ+=1;
        }

        if(slot[0][2]==slot[1][1]&&slot[1][1]==slot[2][0]){
            check_vertical_count+=1;
            slotWinValue[1][slotWinPlaceOfJ] = slot[1][1];
            slotWinPlaceOfJ+=1;
        }
        
        //System.out.println("check_vertical_count is now "+check_vertical());
        return check_vertical_count;
    }
    

    int[][] resetWinValue(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]= -1;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        Slotgame gamePlay = new Slotgame();
        gamePlay.run();
    }
}
