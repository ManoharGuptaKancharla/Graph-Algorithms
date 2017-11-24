/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manohar_gupta
 */

/* Undirected Graph*/

import java.lang.*;
import java.util.*;

public class Graph {

    /**
     *
     */
    protected Vertex vertexList[];
    protected LinkedHashSet<Integer> vertices[];
    protected int vertexcount=0;
    public Graph(int v){
        vertexcount=v;
        vertexList=new Vertex[vertexcount];
        vertices = new LinkedHashSet[vertexcount];
        for(int i=0;i<vertexcount;i++){
            vertexList[i]=new Vertex(i);
            vertices[i]=new LinkedHashSet<>();
        }                
    }
    public void addEdge(int source,int dest){
        vertices[source].add(dest);
        vertices[dest].add(source);
        vertexList[source].outdegree++;
        vertexList[source].indegree++;
        vertexList[dest].outdegree++;
        vertexList[dest].indegree++;
    }
    public void removeEdge(int source,int dest){
        vertices[source].remove(dest);
        vertices[dest].remove(source);
        vertexList[source].outdegree--;
        vertexList[source].indegree--;
        vertexList[dest].outdegree--;
        vertexList[dest].indegree--;
    }
    public void display(int i){
        System.out.println(vertexList[i].v);
    }
    public int getAdjUnvisitedVertex(int v){
        for(int i: vertices[v]){
            if(vertexList[i].visited==false){
                return i;
            }
        }
        return -1;
    }
    
    
    
}
