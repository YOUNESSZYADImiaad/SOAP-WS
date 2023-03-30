<?php
$mt = 0;
if (isset($_POST['action'])) {
    $action = $_POST['action'];
    if ($action == "Convert") {
        $mt = $_POST['montant'];
        $client = new SoapClient("http://localhost:9191/BanqueWS?wsdl");
        $param = new stdClass();
        $param->montant = $mt;
        $rep = $client->__soapCall("Convert", array($param));
        $res = $rep->return;
    } elseif ($action == "List Comptes") {
        $client = new SoapClient("http://localhost:9191/BanqueWS?wsdl");
        $res2 = $client->__soapCall("listComptes", array());
    }
}
?>
<!DOCTYPE html>
<html>

<head>
    <title>Client SOAP</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="container">
        <form method="post" action="ClientSOAP.php">
            <h3>Montant:
                <input type="text" name="montant" value="<?php echo ($mt) ?>">
                <input type="submit" value="Convert" name="action">
            </h3>
        </form>
        <div class="result">
            <h3>Result:
                <?php
                if (isset($res)) {
                    echo ($res) . " EUR";
                }
                ?>
            </h3>
        </div>
        <form method="post" action="ClientSOAP.php">
            <input type="submit" value="List Comptes" name="action">
        </form>
        <?php if (isset($res2)) { ?>
            <table border="1" width="100%">
                <tr>
                    <th>CODE</th>
                    <th>SOLDE</th>
                </tr>
                <?php foreach ($res2->return as $cp) { ?>
                    <tr>
                        <td><?php echo ($cp->code) ?></td>
                        <td><?php echo ($cp->solde) ?></td>
                    </tr>
                <?php } ?>
            </table>
        <?php } ?>
    </div>
</body>

</html>