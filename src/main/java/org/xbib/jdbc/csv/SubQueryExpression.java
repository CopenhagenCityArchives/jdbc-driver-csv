/*
 *  CsvJdbc - a JDBC driver for CSV files
 *  Copyright (C) 2014 Simon Chenery
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.xbib.jdbc.csv;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SubQueryExpression extends Expression {
    private ParsedStatement parsedStatement;

    public SubQueryExpression(ParsedStatement parsedStatement) {
        this.parsedStatement = parsedStatement;
    }

    public Object eval(Map<String, Object> env) throws SQLException {
        throw new SQLException(CsvResources.getString("subqueryNotSupported"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(parsedStatement.toString());
        sb.append(")");
        return sb.toString();
    }

    public List<String> usedColumns() {
        return new LinkedList<String>();
    }

    public List<AggregateFunction> aggregateFunctions() {
        return new LinkedList<AggregateFunction>();
    }
}
