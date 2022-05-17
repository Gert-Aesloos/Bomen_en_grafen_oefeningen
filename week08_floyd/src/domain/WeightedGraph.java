package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] getPointerMatrix() {
        int[][] pointerMatrix = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] DMatrix = this.gewichtenMatrix.clone();
        for (int i=0;i<DMatrix.length;i++) {
            DMatrix[i]=DMatrix[i].clone();
        }
        int punten= this.gewichtenMatrix.length;
        for (int k = 0; k < punten; k++) {
            for (int i = 0; i < punten; i++) {
                for (int j = 0; j < punten; j++) {
                    if (DMatrix[i][k] + DMatrix[k][j] < DMatrix[i][j]) {
                        DMatrix[i][j] = DMatrix[i][k] + DMatrix[k][j];
                        pointerMatrix[i][j] = k + 1;
                    }
                }
            }
        }
		return pointerMatrix;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] pointer) {
		List<Integer> res = new ArrayList<>();
        if (i == j){
            return res;
        }
        else {
            int tussenstation= pointer[i-1][j-1];
            if(tussenstation==0){
                res.add(i);
                res.add(j);
            }
            else {
                res.addAll(getShortestPath(i,tussenstation,pointer));
                res.remove(res.size()-1);
                res.addAll(getShortestPath(tussenstation,j,pointer));
            }
        }

		return res;
	}

	public int berekenLengte(List<Integer> pad) {
        int res=0;
        int i,j;
        for (int k=0;k<pad.size()-1;k++){
            i=pad.get(k);
            j=pad.get(k+1);
            res+=this.gewichtenMatrix[i-1][j-1];
        }

        return res;
	}

}
