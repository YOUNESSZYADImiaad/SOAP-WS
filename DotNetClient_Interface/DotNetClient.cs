using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DotNetClient_Interface
{
    public partial class DotNetClient : Form
    {
        public DotNetClient()
        {
            InitializeComponent();
        }
        ServiceReference1.BanqueServiceClient stub = new ServiceReference1.BanqueServiceClient();
        private void ConvertButton_Click(object sender, EventArgs e)
        {
            double Montant = double.Parse(TextBoxDH.Text);
            TextBoxEUR.Text = stub.Convert(Montant).ToString();
        }

        private void ButtonListComptes_Click(object sender, EventArgs e)
        {
            DataGridViewListComptes.AutoGenerateColumns = false;
            List<ServiceReference1.compte> cptes = stub.listComptes().ToList();

            var comptesList = new BindingList<ServiceReference1.compte>(cptes);

            DataGridViewListComptes.DataSource = comptesList;
        }

        private void ButtonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
