require 'mysql2'
require 'json'
require './config'
require 'iconv'

class DB_Manager

	def open_connection
		@@mysql_client = Mysql2::Client.new(:host => Db_config.db_server, :username => Db_config.username, :password => Db_config.password, :database => Db_config.db_name)
	end

	def get_cupcakes
		open_connection
		cupcakes = Array.new
		cupcake_query = @@mysql_client.query("SELECT name,cupcake,frosting,thumbnail,description from cupcake_listview", :as=>:array)
		cupcake_query.each do |row|
			cupcakes << {:name=>row[0],:cupcake=>row[1],:frosting=>row[2],:images=>{:thumbnail=>row[3]},:description=>row[4]}
		end
		return {:cupcakes=>cupcakes}.to_json
		@@mysql_client.close()
	end
		
		
end
