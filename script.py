import mysql.connector
import csv

# Configurações do banco de dados
db_config = {
    'host': 'localhost',
    'user': 'root',       # Usuário padrão do XAMPP
    'password': '',       # Senha padrão do XAMPP (geralmente vazia)
    'database': 'pokedex'  # Substitua pelo nome do seu banco de dados
}

# Nome do arquivo CSV
csv_file = 'pokemon.csv'  # Substitua pelo caminho do seu arquivo CSV

# Nome da tabela
table_name = 'pokemon'  # Substitua pelo nome da sua tabela

try:
    # Conexão com o banco de dados
    connection = mysql.connector.connect(**db_config)
    cursor = connection.cursor()

    with open(csv_file, newline='', encoding='utf-8') as file:
        csv_data = csv.reader(file)
        headers = next(csv_data)  # Pega os cabeçalhos do CSV

        # Ignorar a primeira coluna dos dados (ID no CSV)
        headers = headers[1:]

        # Query para inserir os dados
        insert_query = f"""
        INSERT INTO {table_name} 
        (name, type1, type2, total, hp, attack, defense, sp_atk, sp_def, speed, generation, legendary)
        VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        """
        
        # Ler e inserir os dados do CSV
        for row in csv_data:
            row = row[1:]  # Ignorar a primeira coluna (assumindo que é um ID no CSV)
            # Converter 'True'/'False' para booleanos reais
            row[-1] = row[-1].lower() == 'true'
            cursor.execute(insert_query, row)

        # Confirmar as transações
        connection.commit()
        print(f"Dados inseridos com sucesso na tabela '{table_name}'.")
except mysql.connector.Error as err:
    print(f"Erro: {err}")
finally:
    # Fechar conexões
    if cursor:
        cursor.close()
    if connection:
        connection.close()
