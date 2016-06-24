import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Graph {
	
	int CountOfVertex=0;
	int PointOfVertex=0;
	
	ArrayList<AdjList>[] adj;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		long start_time = System.currentTimeMillis();
		graph.run();
		long end_time = System.currentTimeMillis();
		
		System.out.println("Elapsed Tiime: " + (end_time - start_time));
	}
	
	@SuppressWarnings("unchecked")
	private void run() throws Exception{
		
		FileReader fr = new FileReader("res/aaa.txt");
		BufferedReader br = new BufferedReader(fr);
		
		CountOfVertex = Integer.parseInt(br.readLine());
		
		adj = (ArrayList <AdjList>[]) new ArrayList[CountOfVertex];
		
		int countOfEdge = Integer.parseInt(br.readLine());
		
		String[] edge;
		
		int count=0;
		
		for(int i = 0; i < countOfEdge; i++){
			edge = br.readLine().split(" ");
			/*
			StringTokenizer st = new StringTokenizer(edge);
			String from = st.nextToken();
			String to = st.nextToken();
			int weight = Integer.parseInt(st.nextToken());
			*/
			String from = edge[0];
			String to = edge[1];
			int weight = Integer.parseInt(edge[2]);
//			System.out.println("From: " + from + " To: " + to + " Weight: " + weight);
			makeGraph(from, to, weight);
		}
		
		System.out.println("====== Vertex =======");
		for(int i = 0; i < PointOfVertex; i++){
			System.out.println(adj[i].get(0).vertex);
		}
		
		System.out.println("====== Adjacent List =======");
		for(int i = 0; i < CountOfVertex; i++){
			for(int j = 0; j < adj[i].size(); j++){
				System.out.print(adj[i].get(j).vertex + "(" + adj[i].get(j).weight + ") -> ");
			}
			System.out.println("");
		}
		
		CountOfVertex = 0;
		PointOfVertex = 0;
		br.close();
	}
	
	private void makeGraph(String from, String to, int weight){
				
		if (findVertex(from) == -1){ 
			adj[PointOfVertex] = new ArrayList<AdjList>();
			adj[PointOfVertex].add(new AdjList(from));
			PointOfVertex++;
			
		}
		if(findVertex(to) == -1){
			adj[PointOfVertex] = new ArrayList<AdjList>();
			adj[PointOfVertex].add(new AdjList(to));
			PointOfVertex++;			
		}
		makeEdge(from, to, weight);
	}
	
	private void makeEdge(String from, String to, int weight){
		
		int index;
		
		index = findVertex(from);
		adj[index].add(new AdjList(to,weight));
		
		index = findVertex(to);
		adj[index].add(new AdjList(from,weight));
	}
	
	private int findVertex(String v){

		int index = -1;
		
		for(int i = 0; i < PointOfVertex; i++){
			if(adj[i].get(0).getVertex().equals(v)){			
				index = i;
				break;
			}
		}
		return index;
	}
	
	class AdjList{
		String vertex;
		int	weight;
		
		AdjList(String v){
			vertex = v;
			weight = 0;
		}
		AdjList(String v, int w){
			vertex = v;
			weight = w;
		}
		public String getVertex() {
			return vertex;
		}
		public void setList(String vertex) {
			this.vertex = vertex;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
	}
}
