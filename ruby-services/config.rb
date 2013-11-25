class Db_config
    @@user="root"
    @@pass=""
    @@db="fakecake"
    @@host="localhost"

    def initialize
        puts "Configuration initialized."
    end

    def self.username
        return  @@user
    end

    def self.password
        return @@pass
    end

    def self.db_server
        return @@host
    end

    def self.db_name
        return @@db
    end
end

