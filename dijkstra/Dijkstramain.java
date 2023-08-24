package dijkstra;
import java.util.Scanner;
public class Dijkstramain{
public static void main(String[] args) {
	// TODO Auto-generated method stub
	int i,j;
	int dist[]=new int[10],visited[]=new int[10];
	int cost[][]=new int[10][10],path[]=new int[10];
	Scanner in=new Scanner(System.in)  ;
	System.out.println("DIJKSTRA");
	System.out.println("enter no. of nodes");
	int n=in.nextInt();
	System.out.println("enter cost matrix");
	for(i=1;i<=n;i++)
	{
	for(j=1;j<=n;j++)
	{
	cost[i][j]=in.nextInt();
	}
	}
	System.out.println("the entered cost matrix is");
	for(i=1;i<=n;i++)
	{
	for(j=1;j<=n;j++)
	{
	System.out.print(cost[i][j]+"\t");
	}
	System.out.println();
	}
	System.out.println("enter source ");
	int sv=in.nextInt();
	Dij(cost,dist,sv,n,path,visited);
	PrintPath(sv,n,dist,path,visited);
	System.out.println("-----------");
	}
	static void Dij(int cost[][],int dist[],int sv,int n,int path[],int visited[])
	{
	int count=2,min,v=0;
	for(int i=1;i<=n;i++)
	{
	visited[i]=0;
	dist[i]=cost[sv][i];
	if(cost[sv][i]==999)
	path[i]=0;
	else
	path[i]=sv;
	}
	visited[sv]=1;
	while(count<=n)
	{
	min=999;
	for(int w=1;w<=n;w++)
	if((dist[w]<min)&&(visited[w]==0))
	{
	min=dist[w];
	v=w;
	}
	visited[v]=1;
	count++;
	for(int w=1;w<=n;w++)
	{
	if((dist[w]>dist[v]+cost[v][w]))
	{
	dist[w]=dist[v]+cost[v][w];
	path[w]=v;
	}
	}
	}
	}
	static void PrintPath(int sv,int n,int dist[],int path[],int visited[])
	{
	for(int w=1;w<=n;w++)
	{
	if(visited[w]==1&&w!=sv)
	{
	System.out.print("shortest distance between ");
	System.out.println(sv+"->"+w+" is "+dist[w]);
	int t=path[w];
	System.out.print("the path is");
	System.out.print(" "+w);
	while(t!=sv)
	{
	System.out.print("<->"+t);
	t=path[t];
	}
	System.out.println("<->"+sv);
	}
	}
	}
}
