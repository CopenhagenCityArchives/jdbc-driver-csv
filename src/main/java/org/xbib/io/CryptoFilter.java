/*
 *  CsvJdbc - a JDBC driver for CSV files
 *  Copyright (C) 2001  Jonathan Ackerman
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.xbib.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Minimalistic approach to decrypting a file.
 * A class implementing this interface is required to return one character at a
 * time from the given InputStream. the InputStream is encrypted, the client
 * receives it clear-text.
 * The encryption used may require you to read more than one character from the
 * InputStream, but this is your business, as is all initialization required by
 * your cipher, the client will be offered one deciphered character at a time.
 *
 */
public interface CryptoFilter {
    abstract public int read(InputStream in) throws IOException;

    abstract public void write(OutputStream out, int ch) throws IOException;

    abstract public int read(InputStream in, byte[] b, int off, int len) throws IOException;

    abstract public int read(InputStream in, byte[] b) throws IOException;

    abstract public void reset();

}