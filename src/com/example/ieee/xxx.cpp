#include <stdio.h>
#include <stdlib.h>
int main(){
	int n,i;
	unsigned long int j,k;
	scanf("%d %d\n",&n,&k);
	int a[n];
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	int max1=0;
	int max2=0;
	int sum=0;
	for(i=0;i<n;i++)
	{
          sum=sum+a[i];
		  if(a[i]>max1)
		   	{
		   		max2=max1;
		   		max1=a[i];
			}
		  else if(a[i]>max2)
		    {
		    	max2=a[i];
			}
	}

	for(j=0;j<k;j++)
	{
       int max=0;
		max=max2;
		max2=max1;
		max1=max1+max;
		sum=sum+max1;
	}
	printf("%d",&sum);
	return 0;
}