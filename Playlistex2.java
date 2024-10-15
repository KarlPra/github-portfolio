import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Playlistex2 {

  public static void main(String[] args) {
    
  File myFile = new File("corpus.csv");
  Scanner scanner = new Scanner(System.in);
  String playlist="";
  String checkerFalse="false";
  String checkerTrue="true";
  int Minutestot=0;
  int Secondstot=0;
  int Hourstot=0;
  int Minutestemp=0;
  int Secondstemp=0;
  String Minutesfin="";
  String Secondsfin="";
  String timer="0";
  int K=0;
  int J=0;
  int count=0;
  int countsongs=1;
  int i=0;


 
  
  

  
  int N=0;
    while(N!=5){

      try{
                Scanner reader = new Scanner(myFile);
                reader.useDelimiter(",|\\n");
                System.out.print("+-----------------------------------------------------------------------------------------------+\n\n");
                System.out.println("|                                        UtepTube Corpus                                        |"+"\n");
                System.out.print("+-------------+---------------------------------------------------+---------------------+-------+\n\n");
                while(reader.hasNext()){
                  String videoId = reader.next();
                  String videoTitle= reader.next();
                  String videoCreator = reader.next();
                  String  Minutes= reader.next();
                  String  Seconds= reader.next();
                  String prerollad = reader.next();
                  String  midrollad = reader.next();
                  String  postrollad = reader.next();
                  
                  System.out.print("|"+videoId+"  ");
                  //System.out.print();
                  System.out.print("|"+videoTitle+"  ");
                  //System.out.print("|");
                  System.out.print("|"+videoCreator+"\t");
                  //System.out.print("|");
                  System.out.print("| "+ Minutes);
                  //System.out.print("|");
                  System.out.println(":"+ Seconds +" |"+"\n");
                  //System.out.print("|"+prerollad);
                  //System.out.print("|"+midrollad);
                  //System.out.println("|"+postrollad);
                  System.out.print("+-------------+---------------------------------------------------+---------------------+-------+\n\n");
                  
                }
                
                    }catch(FileNotFoundException e){
                  System.out.println("error");
                
            }

      System.out.println("\nWelcome to UtepTube! Please select an option below to continue");
      System.out.println("\t\t1. List videos in corpus");
      System.out.println("\t\t2. Add video to playlist");
      System.out.println("\t\t3. View playlist");
      System.out.println("\t\t4. Clear playlist");
      System.out.println("\t\t5. Close UtepTube\n");
      N = scanner.nextInt();

      //Step 1
      if(N==1){
        
        
      }

          //step 2

      if(N==2){


            try{

            Scanner reader = new Scanner(myFile);
            reader.useDelimiter(",|\\n");
            System.out.println("2. Add video to playlist by inserting the URL:\n");
            //taking song input from user
            String SongToadd = scanner.next(); 
            //Checking the input
            boolean keepGoing=false;
              while(reader.hasNext() && keepGoing==false){
                String videoId = reader.next();
                String videoTitle= reader.next();
                String videoCreator = reader.next();
                  
                String  Minutes= reader.next();
                String  Seconds= reader.next();
                String prerollad = reader.next();
                String  midrollad = reader.next();
                String  postrollad = reader.next();
                      if(videoId.equals(SongToadd)){
                        keepGoing=true;
                        videoId=videoId.trim(); 
                        videoTitle=videoTitle.trim();
                        videoCreator=videoCreator.trim();
                        prerollad=prerollad.trim();
                        midrollad=midrollad.trim();
                        postrollad=postrollad.trim();
                        System.out.println("\nExcellent choice!");
                        System.out.println("\n"+videoTitle);
                        System.out.println("\n"+videoCreator+"\n");

                        K= Integer.valueOf(Minutes);
                        J= Integer.valueOf(Seconds);
                        
                        Minutestot=Minutestot+K;
                        Secondstot=Secondstot+J;
                        count++;


                          if(countsongs<10){
                          playlist=playlist+("  "+countsongs+". "+"https://youtu.be/"+videoId+" | "+Minutes+":"+Seconds+" ( ");
                                countsongs++;
                          }else{
                            playlist=playlist+(" "+countsongs+". "+"https://youtu.be/"+videoId+" | "+Minutes+":"+Seconds+" ( ");
                            countsongs++;
                          }

                          if(prerollad.equals(checkerFalse)&&midrollad.equals(checkerFalse)&&postrollad.equals(checkerFalse)){
                             playlist=playlist+("no ads "); 
                            }
                          if(prerollad.equals(checkerTrue)){
                            playlist=playlist+("+30s preroll ");
                              Secondstot=Secondstot+30;
                            }
                          if(midrollad.equals(checkerTrue)){
                            System.out.println("Do you want to skip the midroll ad?(True or False):");
                            boolean skipAdd = scanner.nextBoolean();
                            if(skipAdd==true){
                              playlist=playlist+("+10s midroll ");
                              Secondstot=Secondstot+10;
                            }
                            else{

                                  playlist=playlist+("+2m midroll ");
                                  Minutestot=Minutestot+2;
                                  }
                              
                            }
                          if(postrollad.equals(checkerTrue)){
                            playlist=playlist+("+5s postroll ");
                            Secondstot=Secondstot+5;
                          }
                          playlist=playlist+(")"+"\n");

                        
                        
                      //System.out.println(playlist);

            }
                        }
            if(keepGoing==false){
              System.out.println("Invalid Url");

          }
    
        }catch(FileNotFoundException e){
      System.out.println("error");
    }


            }

    //step 3
    if(N==3){

      System.out.println("------------- YOUR PLAYLIST ------------");
        for(i=0;i<count;i++){
            if(Secondstot>60){
              Secondstot-=60;
              Minutestot+=1;
            }
            if(Minutestot>60){
              Minutestot-=60;
              Hourstot+=1;
            }
            }
            if (Minutestot < 10) {
            Minutesfin = Integer.toString(Minutestot);
            Minutesfin=timer+Minutesfin;
              }else{
                Minutesfin =Integer.toString(Minutestot);
              }

            if(Secondstot < 10){
                Secondsfin = Integer.toString(Secondstot);
                Secondsfin =timer + Secondsfin;
                }else{
                Secondsfin =Integer.toString(Secondstot);
              }
      System.out.println(playlist);
      System.out.println("Total play time: "+Hourstot+":"+Minutesfin+":"+Secondsfin);
      
    }
    
    //step 4
    if(N==4){

      System.out.println("Do you want to clear your playlist?(True or False):");
      boolean playlistclear = scanner.nextBoolean();
      if(playlistclear==true){
      playlist="";
      Minutestot=0;
      Secondstot=0;
      }

    }
}


}


    
}

