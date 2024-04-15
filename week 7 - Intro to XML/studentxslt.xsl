<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "1.0" xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<HTML>
    <BODY>
        <H1>Student Information</H1>

        <table border = "1" bgcolor = "green">
            <tr>
                <th>Student Name</th>
                <th>Student Pin Number</th>
                <th>Branch</th>
            </tr>
            <xsl:for-each select = "studentinfo/student">
                <tr>
                    <td>
                        <xsl:value-of select = "sname" />
                    </td>
                    <td>
                        <xsl:value-of select = "spinno" />
                    </td>
                    <td>
                        <xsl:value-of select = "sbranch" />
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </BODY>
</HTML>
</xsl:template>
</xsl:stylesheet>