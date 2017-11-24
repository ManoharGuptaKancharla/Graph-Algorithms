/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manohar_gupta
 */

/*-------------- Vertex of a Graph----------- */
class Vertex{
    protected int v;
    protected boolean visited;
    protected int indegree=0;
    protected int outdegree=0;
    protected int weight=1;
    public Vertex(int v){
        this.v=v;
        visited=false;
    }
}
