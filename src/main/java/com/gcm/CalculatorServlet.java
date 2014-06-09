/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the 
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gcm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * A simple servlet taking advantage of features added in 3.0.
 * </p>
 * 
 * <p>
 * The servlet is registered and mapped to /CalculatorServlet using the {@linkplain WebServlet
 * @HttpServlet}. The {@link CalculatorService} is injected by CDI.
 * </p>
 * 
 * @author Hivana Macedo
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

	public int somar(int num1, int num2) {
		return num1 + num2;
	}

	public int subtrair(int num1, int num2) {
		return num1 - num2;
	}

	public int multiplicar(int num1, int num2) {
		return num1 * num2;
	}

	public double dividir(double num1, double num2) {
		return num1 / num2;
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		CalculatorServlet calc = new CalculatorServlet();

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		String op = request.getParameter("operacao");

		out.print("<html>");
		out.print("<head><title>Resultado</title></head>");
		out.print("<body>");

		switch (op.charAt(0)) {
		case '+':
			out.print(num1 + " + " + num2 + " = <strong>"
					+ calc.somar(num1, num2) + "</strong>");
			break;
		case '-':
			out.print(num1 + " - " + num2 + " = <strong>"
					+ calc.subtrair(num1, num2) + "</strong>");
			break;
		case '*':
			out.print(num1 + " * " + num2 + " = <strong>"
					+ calc.multiplicar(num1, num2) + "</strong>");
			break;
		case '/':
			out.print(num1 + " / " + num2 + " = <strong>"
					+ calc.dividir(num1, num2) + "</strong>");
			break;
		}
		out.print("<br><a href='index.html'>voltar</a>");
		out.print("<body>");
		out.print("</html>");

	}

}

