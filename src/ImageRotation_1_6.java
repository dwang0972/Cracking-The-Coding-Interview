import java.awt.*;
import java.util.Random;

/**
 * Created by david on 12/22/2016.
 */
public class ImageRotation_1_6 {
    static int N = 0;
    static int[][] picture;
    int[] left, top, right, bottom;



    public static void main(String[] args) {
        picture = new int[4][4];
        ImageRotation_1_6 ir = new ImageRotation_1_6(picture);
        fillPic();

        ir.rotateImage();
    }

    public ImageRotation_1_6(int[][] pic) {
        try {
            N = pic[0].length;
            left = new int[N];
            top = new int[N];
            right = new int[N];
            bottom = new int[N];
        } catch (NullPointerException e) {
            System.out.println("input array is null");
        }
    }

    public static void fillPic() {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                picture[i][j] = rand.nextInt(10);
                System.out.print("|" + picture[i][j] + "|");
            }
            System.out.println("");
        }
    }

    public void rotateImage() {
        for (int i = 0; i < N/2; i++) {
            getSides(i);
            rotateLeftUp(i);
            rotateUpRight(i);
            rotateRightDown(i);
            rotateDownLeft(i);
        }
        printArray(picture);
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("|" + picture[i][j] + "|");
            }
            System.out.println("");
        }
    }

    void getSides(int dim) {
        for (int i = 0; i < N - dim; i++) {
            left[i] = picture[N-1-i][dim];
            top[i] = picture[dim][i];
            right[i] = picture[i][N-1-dim];
            bottom[i] = picture[N-1-dim][N-1-i];
        }
    }

    void rotateLeftUp(int dim) {
        for (int i = dim; i < N - dim; i++) {
            picture[dim][i] = left[i];
        }
    }

    void rotateUpRight(int dim) {
        for (int i = dim; i < N - dim; i++) {
            picture[i][N-1-dim] = top[i];
        }
    }

    void rotateRightDown(int dim) {
        for (int i = dim; i < N - i; i++) {
            picture[N-1-dim][N-1-i] = right[i];
        }
    }

    void rotateDownLeft(int dim) {
        for (int i = dim; i < N - 1 - dim; i++) {
            picture[N-1-i][dim] = bottom[i];
        }
    }

    void printArray(int[] arr) {
        System.out.println("");
        for (int x: arr) {
            System.out.print("|" + x + "|");
        }
        System.out.println("");
    }


}
