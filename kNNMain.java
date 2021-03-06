import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	
	//List<DataPoint> dataSet = DataSet.readDataSet(args[0]);
	
	//DataPoint point = dataSet.get(0);
	//DataPoint point2 = dataSet.get(1);
	
	//System.out.println(point.getLabel());
	
	//for (int i = 0; i < 4; i++)
	//{
	//	System.out.println((point.getX())[i]);
	//}
	
    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	
	//List<DataPoint> test = DataSet.getTestSet(dataSet, 0.2);
	//List<DataPoint> training = DataSet.getTrainingSet(dataSet, 0.8);


    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)


    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	KNNClassifier knn = new KNNClassifier(3);
	
	//String predict = knn.predict(dataSet, point);
	//System.out.println(predict);
	


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	int size = 1000;
	double[] iterations = new double[size];
	
	for (int i = 0; i < size; i++)
	{
		double ctr = 0.;
		double acc = 0.;
		
		List<DataPoint> dataSet = DataSet.readDataSet(args[0]);
		List<DataPoint> testSet = DataSet.getTestSet(dataSet, 0.3);
		List<DataPoint> trainingSet = DataSet.getTrainingSet(dataSet, 0.7);
		
		for (int j = 1; j < testSet.size(); j++)
		{
			String prediction = knn.predict(trainingSet, testSet.get(j));
			if (prediction.equals(testSet.get(j).getLabel()))
			{
				ctr++;
			}
		}
		
		acc = 100 * (ctr / testSet.size());
		iterations[i] = acc;
	}

	System.out.println(mean(iterations));
	System.out.print(standardDeviation(iterations));
  }
	

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
