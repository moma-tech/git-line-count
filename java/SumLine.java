import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;

/**
 * 数据聚合
 */
public class SumLine{
    public static void main (String[] args){
        FileReader fileReader = null;
        try{
            // 最终输出result.csv
            File file = new File("result.csv");
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file),"utf-8"); 
            // 数据输入文件 result.data   
            fileReader = new FileReader("result.data");
            BufferedReader bReader = new BufferedReader(fileReader);
            String dataString;
            // 循环读取处理
            while((dataString = bReader.readLine())!=null){
                //遇到项目分隔符， csv换行
                if(dataString.startsWith("----")){
                    osw.write("\r\n");
                }else{
                    // 遇到空格，输出空格后内容
                    // diff-line: 1234  --> 输出 1234
                    if(dataString.trim().contains(" ")){
                        osw.write(dataString.trim().split(" ")[1]);
                    }else{
                        // 仓库文件夹名称
                        osw.write(dataString);
                    }
                    osw.write(",");
                }
            }
            osw.flush();
            osw.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(null!=fileReader){
                try{
                    fileReader.close();
                }catch(IOException io){
                    io.printStackTrace();
                }
            }
        }
    }
}