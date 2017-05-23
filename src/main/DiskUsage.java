import java.io.File;

/**
 * Created by me on 1/8/2017.
 */
public class DiskUsage {

    public  static void main(String args[]){


        System.out.println(calculateDiskSpace("C:\\dev\\programming"));
    }

    private static long calculateDiskSpace(String root) {

        File rootRef = new File(root);
        long total = rootRef.length();

        if(rootRef.isDirectory()){
            for( String item: rootRef.list()){
                System.out.println(item);
                total+=calculateDiskSpace(item);

            }
        }

    return total;
    }
}
