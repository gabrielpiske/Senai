using System;

namespace CalculoMediaAlunos
{
    class Program
    {
        static void Main(string[] args)
        {
            //variavéis
            const int numAlunos = 5;
            string[] nomesAlunos = new string[numAlunos];
            double[,] notasAlunos = new double[numAlunos, 3];
            double[] mediasFinais = new double[numAlunos];

            // Entrada nomes e notas dos alunos
            for (int i = 0; i < numAlunos; i++)
            {
                Console.WriteLine($"Entre com o nome do aluno {i + 1}: ");
                nomesAlunos[i] = Console.ReadLine();

                Console.WriteLine($"Entre com as  notas do aluno {nomesAlunos[i]}:");
                for (int j = 0; j < 3; j++)
                {
                    Console.Write($"Nota {j + 1}: ");
                    notasAlunos[i, j] = Convert.ToDouble(Console.ReadLine());
                }

                // Calcular média final do aluno
                mediasFinais[i] = (notasAlunos[i, 0] + notasAlunos[i, 1] + notasAlunos[i, 2]) / 3;
            }

            // Apresentar tabela com os alunos e suas médias finais
            Console.WriteLine("\nTabela de Médias Finais:");
            Console.WriteLine("-----------------------");
            Console.WriteLine("|   Aluno   |  Média  |");
            Console.WriteLine("-----------------------");
            for (int i = 0; i < numAlunos; i++)
            {
                Console.WriteLine($"| {nomesAlunos[i],-10} | {mediasFinais[i],7:F2} |");
            }
            Console.WriteLine("-----------------------");
        }
    }
}