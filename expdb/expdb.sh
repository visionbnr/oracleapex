C:\Users\nimish.garg>sqlplus "scott/tiger@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=ngarg.mydomain.co.in)(PORT=1521))(CONNECT_DATA=(SERVER=dedicated)(SERVICE_NAME=orcl)))"

SQL*Plus: Release 11.2.0.3.0 Production on Tue Sep 30 15:05:13 2014
Copyright (c) 1982, 2011, Oracle.  All rights reserved.

Connected to:
Oracle Database 11g Release 11.2.0.3.0 - 64bit Production

SQL>

sqlplus username/password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=myhost.mydomain)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=servicename)))

SQL> conn hr/hr@"(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = ora11g-2.example.com)(PORT = 1521)))(CONNECT_DATA = (SERVICE_NAME = ORCL)))"
Connected.

# $Header: EXP_TAB_cmprss.sh  
# *====================================================================================+
# |  Author - DBACLASS ADMIN TEAM 
# |                                                       |
# +====================================================================================+
# |
# | FILENAME
# |     EXP_table_bkp_cmprss_dbaclass.sh
# |
# | DESCRIPTION
# |     Daily Export backup script of a list of table
# | PLATFORM
# |     Linux/Solaris
 
# +===========================================================================+
#!/bin/bash
echo Set Oracle Database Env
export ORACLE_SID=$1
export ORACLE_HOME=/oracle/app/oracle/product/12.1.0/dbhome_1
export LD_LIBRARY_PATH=$ORACLE_HOME/lib:/usr/lib
export PATH=$ORACLE_HOME/bin:$PATH:/usr/local/bin
export TIMESTAMP=`date +%a%d%b%Y`
export EXP_DIR=/export/home/oracle
 
echo =======
echo Export command
echo =======
echo $ORACLE_HOME
$ORACLE_HOME/bin/expdp \'/ as sysdba\' directory=DB_DUMPS dumpfile=expdp_tab_${TIMESTAMP}_%U.dmp logfile=expdp_log_${TIMESTAMP}.log tables=DBATEST.ORDER_TAB PARALLEL=6  COMPRESSION=ALL
 
echo SEND MAIL TO STAKE HOLDERS
echo =======
mailx -s "$ORACLE_SID $TIMESTAMP Export backup logfile" support@dbaclass.com < $EXP_DIR/expdp_log_${TIMESTAMP}.log
echo Export completed at $TIMESTAMP
exit
 
