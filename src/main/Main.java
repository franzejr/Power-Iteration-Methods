package main;

import methods.InverseIteration;
import methods.PowerIteration;
import methods.RegularIteration;
import methods.ShiftedIteration;
import util.EigenValueVector;
import util.Matrix;
import util.ReadFile;

/*
 * Trabalho 10 - Francisco Jose Lins Magalhaes
 * Universidade Federal do Ceara
 * Calculate the both eigenvectors and eigenvalues from the first question
 * @author franzejr
 * 
 */
public class Main {

	public static void main(String[] args) {
		//Arquivoo onde eh dado a matriz inicial
		//File where the matriz is in
		String matrixPath = "matrix.txt";
		//Initial Eigen Vector -- hint
		String initialEigenVectorPath = "initialEigenVector.txt";
		//Error rate
		double error = 0.001;
		try {
			Matrix m = new Matrix(ReadFile.readMatrixFromFile(matrixPath));
			double[] initialEigenVector = Matrix.matrixToVector(ReadFile
					.readMatrixFromFile(initialEigenVectorPath));
			/*Here is possible to choose between the methods */
			
			/*Power Iteration - regular */
			PowerIteration method = new RegularIteration();
			
			/*Inverse Iteration */
			//PowerIteration method = new InverseIteration();
			
			/*Shifted Iteration, you can choose the shifted rate at the class */
			//PowerIteration method = new ShiftedIteration();
			
			//Call to solve method
			EigenValueVector result = method
					.solve(m, initialEigenVector, error);
			method.printCommandLine(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
