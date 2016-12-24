import java.awt.*;
import java.util.Random;

/**
 * Created by david on 12/24/2016.
 * More efficient index by index swapping
 * Does not require O(n) memory by storing into arrays
 */
public class ImageRotation_1_6_alt {
    static int N = 0;
    static int[][] picture;
//    static int[] top;



    public static void main(String[] args) {
        picture = new int[3][3];
        ImageRotation_1_6_alt ir = new ImageRotation_1_6_alt();
        ir.rotateImage();
        printArray(picture);
    }

    public ImageRotation_1_6_alt() {
        N = picture[0].length;
        fillPic();
    }

    static void fillPic() {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                picture[i][j] = rand.nextInt(10);
                System.out.print("|" + picture[i][j] + "|");
            }
            System.out.println("");
        }
    }

    void rotateImage() {
        for (int dim = 0; dim < N/2; dim++) {
            for (int i = dim; i < N - 1 - dim; i++) {
                //save top element
                int top = picture[dim][i];

                //move left side onto top
                picture[dim][i] = picture[N-1-i][dim];

                //move down side onto left
                picture[N-1-i][dim] = picture[N-1-dim][N-1-i];

                //move right side onto down
                picture[N-1-dim][N-1-i] = picture[i][N-1-dim];

                //move top side onto right
                picture[i][N-1-dim] = top;

            }
        }
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("|" + picture[i][j] + "|");
            }
            System.out.println("");
        }
    }



}
