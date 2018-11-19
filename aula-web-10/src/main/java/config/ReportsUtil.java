package config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class ReportsUtil {

    public static Connection getConnection() throws SQLException {
        return HibernateUtil.getSessionFactory()
                .getSessionFactoryOptions()
                .getServiceRegistry()
                .getService(ConnectionProvider.class)
                .getConnection();
    }

    public static void main(String[] args) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from colaborador");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("" + rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportsUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void imprimirRelatorio(String nomeRelatorio, Map parametros) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        HttpServletResponse response = (HttpServletResponse) ec.getResponse();
        response.setContentType("application/pdf");
        response.setHeader("content-disposition", "inline; " + nomeRelatorio + ".pdf");

        ServletOutputStream stream;

        try {
            JasperPrint print = JasperFillManager
                    .fillReport(ec.getRealPath("/relatorios/" + nomeRelatorio + ".jasper"),
                            parametros,
                            getConnection());

            stream = response.getOutputStream();

            JRPdfExporter export = new JRPdfExporter();
            export.setExporterInput(new SimpleExporterInput(print));
            export.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
            export.exportReport();

            stream.flush();
            stream.close();
        } catch (IOException | SQLException | JRException ex) {
            Logger.getLogger(ReportsUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
}
