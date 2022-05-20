
package project.ir.pkg12032670;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectIR12032670 {
    public static boolean tabWord(String s){
        int countTab=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== '-' || s.charAt(i)== '.' || s.charAt(i)== ','){
                countTab++;
            }
        }
        for(int i=0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i)) && s.charAt(i)!= '-' && s.charAt(i)!= '.' && s.charAt(i)!= ','){
                return false;
            }
        }
        if(countTab==0)
            return false;
        return true;
    }

    
    public static boolean isPureWord(String s,ArrayList A){
        for(int i=0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i)) || A.contains((s.charAt(i)+""))){
                return false;
            }
        }
        return true;
    }
    public static boolean emailAddress(String s){
        int at=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i) == '@'){
               at++;
           } 
        }
        if(at==1){
            String[] a=s.split("[@]");
            if(a.length==2 && !a[0].equalsIgnoreCase("") && !a[1].equalsIgnoreCase("")){
                if(a[0].length()>=2){
                    if(a[1].length()>=3){
                        for(int i=0;i<a[1].length();i++){
                            if(a[1].charAt(i) != '.' && !Character.isLetter(a[1].charAt(i))){
                                return false;
                            }
                        }
                        String[] a1=a[1].split("[.]");
                        if(a1.length>=1){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static String cleanWord(String s, ArrayList A){
        String cleanS="";
        if(!s.equalsIgnoreCase("")){
        String x=s.charAt(s.length()-1)+"";
        while(A.contains(x)){
            s=s.substring(0, s.length()-1);
            x=s.charAt(s.length()-1)+"";
        }
        x=s.charAt(0)+"";
        while(A.contains(x)){
            s=s.substring(1, s.length());
            x=s.charAt(0)+"";
        }

        if(emailAddress(s))
            return s;
        else{
            for(int j=0;j<s.length();j++){
                String c=s.charAt(j)+"";
                   if(!A.contains(c) && Character.isLetter(s.charAt(j))){
                       cleanS+=c;
                }
            }
        }
        }
        return cleanS;
    }
    public static int Occ(String s,ArrayList A){
        int occ=0;
        for(int i=0;i<A.size();i++){
            String ss=A.get(i).toString();
            if(ss.equalsIgnoreCase(s))
                occ++;
        }
        return occ;
    }
    public static int OccDoc(String s, int n){
        int o=0;
        for(int k=1;k<=n;k++){
            File f = new File ("doc"+k+"Freq.txt");
        try {
            try(Scanner input = new Scanner (f)){
                while(input.hasNextLine()){
                    String a = input.nextLine();
                    if(!a.equalsIgnoreCase("")){
                        String[] str=a.split("[ ]");
                        
                            if(str[0].equalsIgnoreCase(s)){
                                o++;
                                continue;
                            }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("error occurred.");
        }
        }
        return o;
    }
    public static String occFile(String s, int r){
        if(r==0){
            File f = new File ("docsFreq.txt");
        try {
            try(Scanner input = new Scanner (f)){
                while(input.hasNextLine()){
                    String a = input.nextLine();
                    if(!a.equalsIgnoreCase("")){
                        String[] str=a.split("[ ]");
                        
                            if(str[0].equalsIgnoreCase(s))
                                return str[1];
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("error occurred.");
        }
        }
        else{
        File f = new File ("doc"+r+"Freq.txt");
        try {
            try(Scanner input = new Scanner (f)){
                while(input.hasNextLine()){
                    String a = input.nextLine();
                    if(!a.equalsIgnoreCase("")){
                        String[] str=a.split("[ ]");
                        
                            if(str[0].equalsIgnoreCase(s))
                                return str[1];
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("error occurred.");
        }
        }
    return "0";        
    }
    
    public static ArrayList cosineMatrix(ArrayList a){
        String[][] b;
        double max=0.0;
        
        ArrayList c=new ArrayList();
        int j;
        while(!a.isEmpty()){
            double d=0.0;
            j=0;
            String s="";
            max=0.0;
        for(int i=0;i<a.size();i++){
             s=a.get(i).toString();
            String[] ss=s.split("[ ]");
            d=Double.valueOf(ss[1]);
            if(d !=0.0){
                if(d>max){
                    
                   max=d;
                   j=i;
                }
            }
        }
         if(max > 0.0)
        c.add(a.get(j));
        a.remove(j);
        }
        
        return c;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        ArrayList stopwords=new ArrayList();
        ArrayList punct=new ArrayList();
        ArrayList docsUniqueTerms=new ArrayList();
        ArrayList allterms=new ArrayList();
        
        
        File file1 = new File ("stop_words_english.txt");
        try {
            try(Scanner input = new Scanner (file1)){
                while(input.hasNextLine()){
                    String s = input.nextLine();
                    if(!s.equalsIgnoreCase("")){
                        String[] str=s.split("[ ]");
                        for(int i=0;i<str.length;i++){
                            if(!str[i].equalsIgnoreCase(""))
                                stopwords.add(str[i]);
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("error occurred.");
        }
        
        File file2 = new File ("punctuations.txt");
        try {
            try(Scanner input = new Scanner (file2)){
                while(input.hasNextLine()){
                    String s = input.nextLine();
                    if(!s.equalsIgnoreCase("")){
                        String[] str=s.split("[ ]");
                        for(int i=0;i<str.length;i++){
                            if(!str[i].equalsIgnoreCase(""))
                                punct.add(str[i]);
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("error occurred.");
        }
        
        /*for(int i=0;i<punct.size();i++){
            System.out.print(punct.get(i)+"  ");
        }*/
        System.out.println("Enter the number of documents:");
        int numDocs=scan.nextInt();
        int k;
        Stemmer stm=new Stemmer();
        for(k=1;k<=numDocs;k++){
            ArrayList docWords=new ArrayList();
            ArrayList docstp=new ArrayList();
            ArrayList docstm=new ArrayList();
            File f1 = new File ("doc"+k+".txt");
            try(Scanner input = new Scanner (f1)){
                while(input.hasNextLine()){
                    String s = input.nextLine();
                    if(!s.equalsIgnoreCase("")){
                        String[] str=s.split("[ ]");
                        for(int i=0;i<str.length;i++){
                            if(!str[i].equalsIgnoreCase(""))
                                docWords.add(str[i]);
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        try (FileWriter fw1 =new FileWriter("doc"+k+".stp")){
            String a;
            for(int i=0;i<docWords.size();i++){
                if(!stopwords.contains(docWords.get(i).toString()) && !punct.contains(docWords.get(i).toString())){
                    a=docWords.get(i).toString();
                    String b=a.charAt(a.length()-1)+"";
                    if(punct.contains(b)){
                        a=a.substring(0,a.length()-1);
                    }
                    b=a.charAt(0)+"";
                    if(punct.contains(b)){
                        a=a.substring(1,a.length());
                    }
                    if(tabWord(a)){
                        String[] tab=a.split("[-,.]");
                        for(int j=0;j<tab.length;j++){
                            if(!tab[j].equalsIgnoreCase("")){
                                if(!stopwords.contains(tab[j])){
                                    fw1.write(tab[j]);
                                    fw1.write("\r\n");
                                    docstp.add(tab[j]);
                                }
                            }
                        }
                        continue;
                    }                    
                    if(!isPureWord(docWords.get(i).toString(),punct)){
                        a=cleanWord(a,punct);
                    }
                 if(!a.isEmpty() && !stopwords.contains(a) && !a.equalsIgnoreCase("")){
                     docstp.add(a);
                     fw1.write(a);
                     fw1.write("\r\n");
                 }   
                }
                
            }
            fw1.close();
                }   catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        try (FileWriter fw2 =new FileWriter("doc"+k+".stm")){
        for(int j=0;j<docstp.size();j++){
            String s=docstp.get(j).toString();
            s=s.toLowerCase();
            if(!emailAddress(s)){
                char[] ss=s.toCharArray();
                stm.add(ss,ss.length);
                stm.stem();
                s=stm.toString();
                docstm.add(s);
                fw2.write(s);
                fw2.write("\r\n");
                allterms.add(s);
                if(!docsUniqueTerms.contains(s)){
                    docsUniqueTerms.add(s);
                }
            }
            else{
                fw2.write(s);
                fw2.write("\r\n");
                docstm.add(s);
                allterms.add(s);//all terms 
                if(!docsUniqueTerms.contains(s)){
                    docsUniqueTerms.add(s);//unique terms
                }
            }
        }
        }   catch (IOException ex) {
                Logger.getLogger(ProjectIR12032670.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*System.out.println("stemmed words");
        for(int j=0;j<docstm.size();j++){
            System.out.println(docstm.get(j));
        }*/
        
            
            
            ArrayList uniquedoc=new ArrayList();
            try (FileWriter fw3 =new FileWriter("doc"+k+"Freq.txt")){
                
              for(int j=0;j<docstm.size();j++){
                  String s=docstm.get(j).toString();
                  if(!uniquedoc.contains(s)){
                      uniquedoc.add(s);
                  }
        }  
          
        for(int j=0;j<uniquedoc.size();j++){
            String s=uniquedoc.get(j).toString();
            int o=Occ(s,docstm);
            String ss=s+" "+o;
            fw3.write(ss);
            fw3.write("\r\n");
        }
            
        }   catch (IOException ex) {
                Logger.getLogger(ProjectIR12032670.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        docstp.clear();
            docstm.clear();
    }
        
        try (FileWriter fw4 =new FileWriter("docsFreq.txt")){
                
              for(int j=0;j<allterms.size();j++){
                  String s=allterms.get(j).toString();
                  if(!docsUniqueTerms.contains(s)){
                      docsUniqueTerms.add(s);
                  }
        }  
        for(int j=0;j<docsUniqueTerms.size();j++){
            String s=docsUniqueTerms.get(j).toString();
            int o=OccDoc(s,numDocs);
            String ss=s+" "+o;
            fw4.write(ss);
            fw4.write("\r\n");
        }
            
        }   catch (IOException ex) {
                Logger.getLogger(ProjectIR12032670.class.getName()).log(Level.SEVERE, null, ex);
            }
    int x=numDocs+1;
    int y=docsUniqueTerms.size()+1;
    String[][] matrix=new String[x][y];
    matrix[0][0]="";
    for(int j=1;j<x;j++){
        matrix[j][0]="doc"+j;
    }
        for(int jj=1;jj<y;jj++){
            matrix[0][jj]=docsUniqueTerms.get(jj-1).toString();
        }
        String empty=scan.nextLine();
        System.out.println("Enter a query...");
    String q=scan.nextLine();
        System.out.println();
    String[] q1=q.split("[ ]");
    ArrayList q2=new ArrayList();
    for(int j=0;j<q1.length;j++){
        if(!q1[j].equalsIgnoreCase("")){
            String b=q1[j].charAt(q1[j].length()-1)+"";
                    if(punct.contains(b)){
                        q1[j]=q1[j].substring(0,q1[j].length()-1);
                    }
                    b=q1[j].charAt(0)+"";
                    if(punct.contains(b)){
                        q1[j]=q1[j].substring(1,q1[j].length());
                    }
                    if(tabWord(q1[j])){
                        String[] tab=q1[j].split("[-,.]");
                        for(int jj=0;jj<tab.length;jj++){
                            if(!tab[jj].equalsIgnoreCase("")){
                                if(!stopwords.contains(tab[jj])){
                                    q2.add(tab[jj]);
                                }
                            }
                        }
                        continue;
                    }
                                        if(!isPureWord(q1[j],punct)){
                        q1[j]=cleanWord(q1[j],punct);
                    }
                 if(!q1[j].isEmpty() && !stopwords.contains(q1[j]) && !q1[j].equalsIgnoreCase("")){
                     q2.add(q1[j]);
                 }
        }
    }
    ArrayList q3=new ArrayList();
    for(int j=0;j<q2.size();j++){
        String sq=q2.get(j).toString();
        sq=sq.toLowerCase();
        if(!emailAddress(sq)){
                char[] ss=sq.toCharArray();
                stm.add(ss,ss.length);
                stm.stem();
                sq=stm.toString();
                q3.add(sq);
        }
        else
           q3.add(sq); 
    }
 
    ArrayList uniqueQuery=new ArrayList();
        for(int j=0;j<q3.size();j++){
            String v=q3.get(j).toString();
            if(!uniqueQuery.contains(v)){
            uniqueQuery.add(v);
            }
        }
        
        
        
    
    
    String[] query=new String[y-1];
    
        System.out.println("Choose the model for the inverted file: V for vector model -B for boolean and - F for term frequency");
        String model=scan.next();
        char m=model.charAt(0);
        if(m == 'b' || m=='B'){
            for(int r=1;r<x;r++){
             for(int c=1;c<y;c++){
                 String a1=matrix[0][c];
                 if(occFile(a1,r).equalsIgnoreCase("0"))
                   matrix[r][c]="0";
                 else matrix[r][c]="1";
             }
            }
            try (FileWriter fw5 =new FileWriter("Boolean.txt")){
                for(int r=0;r<x;r++){
                    String bb="";
             for(int c=0;c<y;c++){
                 bb+=matrix[r][c]+"  ";
             }
             fw5.write(bb);
             fw5.write("\r\n");
                }
             }
             catch (IOException ex) {
                Logger.getLogger(ProjectIR12032670.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Total nb of unique terms is: "+(y-1));
            System.out.println();
            System.out.println("boolean inverted file:");
            System.out.println();
            for(int r=0;r<x;r++){
                String str="";
             for(int c=0;c<y;c++){
                 str+=matrix[r][c]+"  ";
             }
                System.out.println(str);
             }
              
            for(int j=1;j<y;j++){
                String s=matrix[0][j];
                if(uniqueQuery.contains(s))
                    query[j-1]=Integer.toString(1);
                else query[j-1]=Integer.toString(0);
            }
             System.out.println();
             System.out.println("query array:");
            for(int j=0;j<query.length;j++){
                System.out.print(query[j]+"  ");
                
            }
            double p = Math.pow(10, 3);
            String[][] cosmat=new String[x][2];
            cosmat[0][0]="  ";
            cosmat[0][1]="cosine";
            for(int j=1;j<x;j++){
                cosmat[j][0]="doc"+j;
            }
            
            for(int j=1;j<x;j++){
                double num=0.0,don=0.0,s=0.0,g=0.0;
                for(int h=1;h<y;h++){
                     num+=Double.valueOf(matrix[j][h]) * Double.valueOf(query[h-1])*1.0;
                     s+=Math.pow(Double.valueOf(matrix[j][h])*1.0, 2);
                     g+=Math.pow(Double.valueOf(query[h-1])*1.0,2);
                }
                don=Math.sqrt(s*g*1.0);
                double value=(num*1.0)/(don*1.0);
                double pp = Math.round(value * p) / p;
                cosmat[j][1]=String.valueOf(pp);
            }
            System.out.println();
            System.out.println("cosine matrix");
            for(int j=0;j<x;j++){
                String aa="";
                for(int jj=0;jj<2;jj++){
                   aa+=cosmat[j][jj]+"  ";
                }
                System.out.println(aa);
            }
            
            ArrayList cmat=new ArrayList();
            for(int j=1;j<x;j++){
                String a="";
                for(int jj=0;jj<2;jj++){
                    a+=cosmat[j][jj]+" ";
                }
                a=a.substring(0, a.length()-1);
                cmat.add(a);
            }
            System.out.println();
            System.out.println("ordered cosine matrix:");
            ArrayList cosine=cosineMatrix(cmat);
            
            System.out.println("    cosine");
            for(int j=0;j<cosine.size();j++){
                System.out.println(cosine.get(j));
            }
        }
        
        else if(m == 'v' || m=='V'){
            double p = Math.pow(10, 3);
            for(int r=1;r<x;r++){
             for(int c=1;c<y;c++){
                 String a1=matrix[0][c];
                 double d=Double.valueOf(occFile(a1,r))*1.0;//TF
                   double dd=Double.valueOf(occFile(a1,0))*1.0;
                   double log=Math. log10(numDocs/dd);
                   double tf=d*log;
                  double tfidf=Math.round(tf * p) / p;
                   matrix[r][c]=Double.toString(tfidf);
             }
            }
            try (FileWriter fw5 =new FileWriter("Vector.txt")){
                for(int r=0;r<x;r++){
                    String bb="";
             for(int c=0;c<y;c++){
                 bb+=matrix[r][c]+"  ";
             }
             fw5.write(bb);
             fw5.write("\r\n");
                }
             }
             catch (IOException ex) {
                Logger.getLogger(ProjectIR12032670.class.getName()).log(Level.SEVERE, null, ex);
            }  
          
            System.out.println();
            System.out.println("vector inverted file:");
            System.out.println();
            for(int r=0;r<x;r++){
                String str="";
             for(int c=0;c<y;c++){
                 str+=matrix[r][c]+"  ";
             }
                System.out.println(str);
             }
            
            for(int j=1;j<y;j++){
                double a=Occ(matrix[0][j],q3)*1.0;
                double dd=Double.valueOf(occFile(matrix[0][j],0))*1.0;
                double log=Math. log10(numDocs/dd);
                double tf=a*log;
                double tfidf=Math.round(tf * p) / p;
                query[j-1]=Double.toString(tfidf);
            }
            
            System.out.println();
             System.out.println("query array:");
            for(int j=0;j<query.length;j++){
                System.out.print(query[j]+"  ");
                
            }
            String[][] cosmat=new String[x][2];
            cosmat[0][0]="  ";
            cosmat[0][1]="cosine";
            for(int j=1;j<x;j++){
                cosmat[j][0]="doc"+j;
            }
            
            for(int j=1;j<x;j++){
                double num=0.0,don=0.0,s=0.0,g=0.0;
                for(int h=1;h<y;h++){
                     num+=Double.valueOf(matrix[j][h]) * Double.valueOf(query[h-1])*1.0;
                     s+=Math.pow(Double.valueOf(matrix[j][h])*1.0, 2);
                     g+=Math.pow(Double.valueOf(query[h-1])*1.0,2);
                }
                don=Math.sqrt(s*g*1.0);
                double value=(num*1.0)/(don*1.0);
                double pp = Math.round(value * p) / p;
                cosmat[j][1]=String.valueOf(pp);
            }
            System.out.println();
            System.out.println("cosine matrix");
            for(int j=0;j<x;j++){
                String aa="";
                for(int jj=0;jj<2;jj++){
                   aa+=cosmat[j][jj]+"  ";
                }
                System.out.println(aa);
            }
            
            ArrayList cmat=new ArrayList();
            for(int j=1;j<x;j++){
                String a="";
                for(int jj=0;jj<2;jj++){
                    a+=cosmat[j][jj]+" ";
                }
                a=a.substring(0, a.length()-1);
                cmat.add(a);
            }
            System.out.println();
            System.out.println("ordered cosine matrix:");
            ArrayList cosine=cosineMatrix(cmat);
            
            System.out.println("    cosine");
            for(int j=0;j<cosine.size();j++){
                System.out.println(cosine.get(j));
            }
            
            
        }
        else if(m == 'f' || m=='F'){
            for(int r=1;r<x;r++){
             for(int c=1;c<y;c++){
                 String a1=matrix[0][c];
                 int d=Integer.valueOf(occFile(a1,r));//TF
                   matrix[r][c]=Integer.toString(d);
             }
            }
          try (FileWriter fw5 =new FileWriter("TermFreq.txt")){
                for(int r=0;r<x;r++){
                    String bb="";
             for(int c=0;c<y;c++){
                 bb+=matrix[r][c]+"  ";
             }
             fw5.write(bb);
             fw5.write("\r\n");
                }
             }
             catch (IOException ex) {
                Logger.getLogger(ProjectIR12032670.class.getName()).log(Level.SEVERE, null, ex);
            }  
          
            System.out.println();
            System.out.println("TermFrequency inverted file:");
            System.out.println();
            for(int r=0;r<x;r++){
                String str="";
             for(int c=0;c<y;c++){
                 str+=matrix[r][c]+"  ";
             }
                System.out.println(str);
             }
            
            for(int j=1;j<y;j++){
                query[j-1]=Integer.toString(Occ(matrix[0][j],q3));
            }
            
            System.out.println();
             System.out.println("query array:");
            for(int j=0;j<query.length;j++){
                System.out.print(query[j]+"  ");
                
            }
            double p = Math.pow(10, 3);
            String[][] cosmat=new String[x][2];
            cosmat[0][0]="  ";
            cosmat[0][1]="cosine";
            for(int j=1;j<x;j++){
                cosmat[j][0]="doc"+j;
            }
            
            for(int j=1;j<x;j++){
                double num=0.0,don=0.0,s=0.0,g=0.0;
                for(int h=1;h<y;h++){
                     num+=Double.valueOf(matrix[j][h]) * Double.valueOf(query[h-1])*1.0;
                     s+=Math.pow(Double.valueOf(matrix[j][h])*1.0, 2);
                     g+=Math.pow(Double.valueOf(query[h-1])*1.0,2);
                }
                don=Math.sqrt(s*g*1.0);
                double value=(num*1.0)/(don*1.0);
                double pp = Math.round(value * p) / p;
                cosmat[j][1]=String.valueOf(pp);
            }
            System.out.println();
            System.out.println("cosine matrix");
            for(int j=0;j<x;j++){
                String aa="";
                for(int jj=0;jj<2;jj++){
                   aa+=cosmat[j][jj]+"  ";
                }
                System.out.println(aa);
            }
            
            ArrayList cmat=new ArrayList();
            for(int j=1;j<x;j++){
                String a="";
                for(int jj=0;jj<2;jj++){
                    a+=cosmat[j][jj]+" ";
                }
                a=a.substring(0, a.length()-1);
                cmat.add(a);
            }
            
            System.out.println();
            System.out.println("ordered cosine matrix:");
            ArrayList cosine=cosineMatrix(cmat);
            
            System.out.println("    cosine");
            for(int j=0;j<cosine.size();j++){
                System.out.println(cosine.get(j));
            }
            
            
        }
        else System.out.println("you didn't input the right option....");
        
    }
        
            }


