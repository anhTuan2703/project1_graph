package com.mycompany.mavenproject;

import javax.swing.JFrame;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxGraph;

public class Mavenproject extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	public Mavenproject()
	{
		super("Hello, World!");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object v1 = graph.insertVertex(parent, null, "Xin chào", 20, 20, 80, 30, "strokeColor=red;fillColor=green");
			Object v2 = graph.insertVertex(parent, null, "Hi!", 240, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);
                        graph.insertEdge(parent, null, "Edge", v2, v1);
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}

	public static void main(String[] args)
	{
		Mavenproject frame = new Mavenproject();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
	}

}