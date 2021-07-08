package algorithms;

public class Permutation 
{
	public static void main(String[] args)
	{
		String str = "mavaya"; 
		int n = str.length(); //check the length of a string.
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n - 1);
	}


	private void permute(String str, int l, int r) //use  permute method  by checking the possible ways of a string. 
	{
		if (l == r)
			System.out.println(str);
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}	
	public String swap(String a, int i, int j) //use swap method for  charcters at the  position
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}