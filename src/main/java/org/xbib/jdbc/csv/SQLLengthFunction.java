package org.xbib.jdbc.csv;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
class SQLLengthFunction extends Expression {
    Expression expression;

    public SQLLengthFunction(Expression expression) {
        this.expression = expression;
    }

    public Object eval(Map<String, Object> env) throws SQLException {
        Object retval = expression.eval(env);
        if (retval != null) {
            retval = retval.toString().length();
        }
        return retval;
    }

    public String toString() {
        return "LENGTH(" + expression + ")";
    }

    public List<String> usedColumns() {
        List<String> result = new LinkedList<String>();
        result.addAll(expression.usedColumns());
        return result;
    }

    public List<AggregateFunction> aggregateFunctions() {
        List<AggregateFunction> result = new LinkedList<AggregateFunction>();
        result.addAll(expression.aggregateFunctions());
        return result;
    }
}
