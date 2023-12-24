package dao;

import com.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements IClientDao {

	@Override
	public Client save(Client p) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO CLIENT (NOM, Email, ADRESS) VALUES (?,?,?)");
					ps.setString(1, p.getNom());
			        ps.setString(2, p.getEmail());
			        ps.setString(3, p.getAdresse());
			        ps.executeUpdate();
			        PreparedStatement ps2=connection.prepareStatement
			        		("SELECT MAX(ID) AS MAX_ID FROM CLIENT");
			        ResultSet rs=ps2.executeQuery();
			        if(rs.next()) {
			        	p.setId(rs.getLong("MAX_ID"));			        	
			        }
			        ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Client> clientsParMC(String mc) {
		List<Client> clients = new ArrayList<>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM CLIENT WHERE EMAIL LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Client p=new Client();
				p.setId(rs.getLong("ID"));
				p.setNom(rs.getString("NOM"));
				p.setEmail(rs.getString("EMAIL"));
				p.setAdresse(rs.getString("ADRESSE"));
				clients.add(p);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client getClient(Long id) {
		Client p= null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("SELECT * FROM CLIENT WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			    p=new Client();
				p.setId(rs.getLong("ID"));
				p.setNom(rs.getString("NOM"));
				p.setEmail(rs.getString("EMAIL"));
				p.setAdresse(rs.getString("ADRESSE"));
							
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public Client update(Client p) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE CLIENT SET NOM=?, EMAIL=?, ADRESSE=? WHERE ID=?") ;
					ps.setString(1, p.getNom());
			        ps.setString(2, p.getEmail());
			        ps.setString(3, p.getAdresse());
			        ps.setLong(4, p.getId());
			        ps.executeUpdate();
			        ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void deleteClient(Long id) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("DELETE FROM CLIENT WHERE ID=?");
					ps.setLong(1, id);
			        ps.executeUpdate();
			        ps.close();
			        
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
