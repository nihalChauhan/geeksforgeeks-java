package geeksforgeeks;
import java.util.*;

public class Array {
    
    int[] a;
    int[] t;
    int n;
    Scanner sc;
    
    public Array(int n) {
        sc=new Scanner(System.in);
        this.n = n;
        a = new int[n];
        t = new int[n];
    }
    
    public void setArray() {
        System.out.println("Enter elements : ");
        for(int i=0; i<n; i++) 
            a[i] = t[i] = sc.nextInt();
    }
    
    private void retemp() {
        System.arraycopy(t, 0, a, 0, n);
    }
    
    public void getArray(int[] p) {
        System.out.print("Array : ");
        for(int i=0; i<n; i++)
            System.out.print(p[i] + " ");
    }
    
    public void menu(){
        System.out.println("\nWelcome to Array Menu\n" );
        System.out.println("1. A Pair with sum x" );
        System.out.println("2. Majority Element" );
        System.out.println("3. Odd Occurences" );
        System.out.println("4. Largest Sum Sub-Sequence" );
        System.out.println("5. Pivoted Binary Search" );
        System.out.println("6. Dual Array Median" );                
        System.out.println("7. Left Offset juggling Rotaion" );                
        System.out.println("8. Left Offset Block Swap Rotaion" );                
        System.out.print("Enter Choice : ");
        switch(sc.nextInt())
        {
            case 1 :System.out.print("Enter Sum : ");
                    sumPair(sc.nextInt());
                    break;
            case 2 :majorElement();
                    break;
            case 3 :System.out.print("Odd Element : " + oddOccurence());
                    break;
            case 4 :maxContiSub();
                    break;
            case 5 :System.out.print("Enter Query Element : ");
                    int x = pivotBinSearch(0, n-1, sc.nextInt());
                    if(x!=-1)
                        System.out.println("Fount at : " + x);
                    else
                        System.out.println("Not found");
                    break;
            case 6 :System.out.println("Enter size of second Array : ");
                    System.out.println("Median of two arrays : " + dualArrMedian(sc.nextInt()));
                    break;
            case 7 :System.out.println("Enter Left Offset : ");
                    juggleRotate(sc.nextInt());
                    break;
            case 8 :System.out.println("Enter Left Offset : ");
                    if(!blockSwapRotate(sc.nextInt()))
                        getArray(a);
                    break;
            default:System.out.println("Invalid Entry : ");
        }        
    }
    
    //Quick Sort Functionality 
    private int parition(int[] b, int left, int right)
    {
        int pivot = b[left];
        int index = right;
        int temp;

        for(int j = right; j > left; j--)
        {
            if(b[j] > pivot)
            {
                temp = b[j];
                b[j] = b[index];
                b[index] = temp;
                index--;
            }
        }

        b[left] = b[index];
        b[index] = pivot;
        return index;
    }

    private void quickSort(int[] b, int left, int right)
    {
        if(left < right)
        {
            int pivot = parition(b, left, right);

            quickSort(b, left, pivot - 1);
            quickSort(b, pivot + 1, right);
        }
    }
    
    private void sumPair(int sum){
        retemp();
        quickSort(this.t,0,n-1);
        int l, r, k;
        r = n-1;
        l = k = 0;
        while(k!=1 && l<=r){
            if((t[l] + t[r]) == sum) k=1;
            else if((t[l] + t[r]) > sum) r--;
            else if((t[l] + t[r]) < sum) l++;
        }
        System.out.print("\nSum pair for " + sum);
        if(k==1)
           System.out.println(" found : [ " + t[l] + ", " + t[r] + " ]");
        else
           System.out.println(" not found");  
    }
    
    private int getCandidate(){
        int mi = 0;
        int c = 1;
        for(int i=1; i<n; i++){
            if(a[mi] == a[i])
                c++;
            else
                c--;
            
            if(c == 0){
                mi = i;
                c = 1;
            }
        }
        return a[mi];
    }
    
    private void majorElement(){
        int c = getCandidate();
        int count = 0;
        for(int i=1; i<n; i++)
            if(a[i] == c)count++;
        
        if(count >= (n/2))
            System.out.println("Majority Element : " + c);
        else
            System.out.println("Majority Element not found.");
    }
    
    private int oddOccurence(){
        int res = 0;
        for(int i=0; i<n; i++)
            res = res ^ a[i];
        return res;
    }
    
    private void maxContiSub(){
        int max_so_far, max_end_here;
        int start, end, s, i;
        end = -1;
        start = 0;
        max_so_far = max_end_here = s = 0;
        for(i=0; i<n; i++){
            if(a[i] > 0){
                max_end_here = max_end_here + a[i];
                max_so_far = max_so_far + a[i];
                start = s;
                end = i;
            }
            else if(max_end_here + a[i] < 0){
                max_end_here = 0;
                s=i+1;
            }
        }
        
        System.out.print("Largest Sum Contigous Sub-Array : [ ");
        for(i=start; i<=end; i++)
            System.out.print(a[i] + " ");
        System.out.println("]");
    }
    
    private int pivotBinSearch(int l, int h, int k){
        if (l > h) return -1;
        
        int m = (l+h)/2;
        if(a[m] == k) return m;
        
        if(a[l]<=a[m]){
            
            if(k <= a[m] && k >= a[l])
                return pivotBinSearch(l, m-1, k);
            
            return pivotBinSearch(m+1, h, k);
        }
        
        if(k >= a[m] && k<= a[h])
            return pivotBinSearch(m+1, h, k);
        
        return pivotBinSearch(l, m-1, k);
    }
    
    private int dualArrMedian(int n2){
        int[] b = new int[n2];
        int i, j, k;
        int m = (n + n2 - 1)/2;
        System.out.println("Enter Elements : ");
        for(i=0; i<n2; i++)
            b[i] = sc.nextInt();
        i = j = 0;
        int current;
        k = -1;
        while(i<n && j<n2){
            if(a[i] < b[j]){
                current = a[i];
                i++;
            }
            else{
                current = b[j];
                j++;
            }
            k++;
            if(k == m)
                return  current;
        }
        if(i<n)
            return a[m-j];
        if(j<n2)
            return a[m-i];
        return 0;
    }
    
    private void juggleRotate(int off) 
    {
        retemp();
        int i, j, k, temp;
        for (i = 0; i<gcd(off, n); i++) 
        {
            
            temp = t[i];
            j = i;
            while (Boolean.TRUE) 
            {
                k = j + off;
                if (k >= n) 
                    k = k - n;
                if (k == i) 
                    break;
                t[j] = t[k];
                j = k;
            }
            t[j] = temp;
        }
        System.out.println("Temproray Array after shift : ");
        getArray(this.t);
    }
    
    private int gcd(int a, int b) 
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    
    private boolean blockSwapRotate(int off){
        retemp();
        int i, j;
        if(off == 0 || off == n) return Boolean.FALSE;
        
        i=off;
        j=n-off;
        while(i != j){
            if(i < j){
                swap(off-1, off+j-i, i);
                j = j - i; 
            }
            else{
                swap(off-i, off, j);
                i = i - j;
            }
        }
        swap(off-i, off, i);
        getArray(t);
        return Boolean.TRUE;
    }
    
    private void swap(int f, int s, int off){
        int temp;
        for(int i=0; i<off; i++){
            temp = t[f+i];
            t[f+i] = t[s+i];
            t[s+i] = temp;
        }
    }
}