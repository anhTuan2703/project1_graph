/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject;

import javax.swing.JFrame;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxKeyboardHandler;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;

public class Validation extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8928982366041695471L;

	public Validation()
	{
		super("Hello, World!");

		Document xmlDocument = mxDomUtils.createDocument();
		Element sourceNode = xmlDocument.createElement("Source");
		Element targetNode = xmlDocument.createElement("Target");
		Element subtargetNode = xmlDocument.createElement("Subtarget");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object v1 = graph.insertVertex(parent, null, sourceNode, 20, 20,
					80, 30);
			Object v2 = graph.insertVertex(parent, null, targetNode, 200, 20,
					80, 30);
			Object v3 = graph.insertVertex(parent, null, targetNode
					.cloneNode(true), 200, 80, 80, 30);
			Object v4 = graph.insertVertex(parent, null, targetNode
					.cloneNode(true), 200, 140, 80, 30);
			graph.insertVertex(parent, null, subtargetNode, 200,
					200, 80, 30);
			Object v6 = graph.insertVertex(parent, null, sourceNode
					.cloneNode(true), 20, 140, 80, 30);
			graph.insertEdge(parent, null, "", v1, v2);
			graph.insertEdge(parent, null, "", v1, v3);
			graph.insertEdge(parent, null, "", v6, v4);
			Object e4 = graph.insertEdge(parent, null, "", v1, v4);
		}
		finally
		{
			graph.getModel().endUpdate();
		}

	

		final mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graph.setMultigraph(false);
		graph.setAllowDanglingEdges(false);
		graphComponent.setConnectable(true);
		graphComponent.setToolTips(true);

		// Enables rubberband selection
		new mxRubberband(graphComponent);
		new mxKeyboardHandler(graphComponent);

		// Installs automatic validation (use editor.validation = true
		// if you are using an mxEditor instance)
		graph.getModel().addListener(mxEvent.CHANGE, new mxIEventListener()
		{
			public void invoke(Object sender, mxEventObject evt)
			{
//				graphComponent.validateGraph();
			}
		});

		// Initial validation
//		graphComponent.validateGraph();

		getContentPane().add(graphComponent);
	}

	public static void main(String[] args)
	{
		Validation frame = new Validation();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
	}
}
