<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>2006-09-16T00:00:00Z</Created>
  <LastSaved>2016-12-19T05:45:28Z</LastSaved>
  <Version>14.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
  <RemovePersonalInformation/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>8016</WindowHeight>
  <WindowWidth>14808</WindowWidth>
  <WindowTopX>240</WindowTopX>
  <WindowTopY>108</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s62">
   <Font ss:FontName="微软雅黑" x:CharSet="134" x:Family="Swiss" ss:Size="11"
    ss:Color="#000000"/>
  </Style>
  <Style ss:ID="s63">
   <Font ss:FontName="微软雅黑" x:CharSet="134" x:Family="Swiss" ss:Size="11"
    ss:Color="#000000"/>
   <Interior ss:Color="#D9D9D9" ss:Pattern="Solid"/>
  </Style>
  <Style ss:ID="s67">
   <Font ss:FontName="微软雅黑" x:CharSet="134" x:Family="Swiss" ss:Size="9"
    ss:Color="#000000"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="8" ss:ExpandedRowCount="11" x:FullColumns="1"
   x:FullRows="1" ss:StyleID="s62" ss:DefaultRowHeight="14.55">
   <Column ss:Index="3" ss:StyleID="s62" ss:Width="63"/>
   <Column ss:StyleID="s62" ss:AutoFitWidth="0" ss:Width="102" ss:Span="1"/>
   <Column ss:Index="6" ss:StyleID="s62" ss:AutoFitWidth="0"
    ss:Width="81.599999999999994" ss:Span="1"/>
   <Column ss:Index="8" ss:StyleID="s62" ss:AutoFitWidth="0" ss:Width="57.6"/>
   <Row ss:AutoFitHeight="0">
    <Cell ss:StyleID="s63"><Data ss:Type="String">账号</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">姓名</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">工号</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">手机号</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">创建人</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">部门</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">角色</Data></Cell>
    <Cell ss:StyleID="s63"><Data ss:Type="String">状态</Data></Cell>
   </Row>
   <#list rows as r>
   <Row ss:AutoFitHeight="0">
    <Cell ss:StyleID="s67"><Data ss:Type="String">${r.userCode}</Data></Cell>
    <Cell ss:StyleID="s67"><Data ss:Type="String">${r.userName}</Data></Cell>
    <Cell ss:StyleID="s67"><Data ss:Type="String" x:Ticked="1">${r.jobNum}</Data></Cell>
    <Cell ss:StyleID="s67"><Data ss:Type="String" x:Ticked="1">${r.cellPhone}</Data></Cell>
    <Cell ss:StyleID="s67"><Data ss:Type="String">${r.createUser}</Data></Cell>
    <Cell ss:StyleID="s67"><Data ss:Type="String">${r.orgName}</Data></Cell>
    <Cell ss:StyleID="s67"><Data ss:Type="String">${r.roleName}</Data></Cell>
    <Cell ss:StyleID="s67"><Data ss:Type="String">${r.delFlag}</Data></Cell>
   </Row>
   </#list>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Unsynced/>
   <Print>
    <ValidPrinterInfo/>
    <PaperSizeIndex>9</PaperSizeIndex>
    <HorizontalResolution>600</HorizontalResolution>
    <VerticalResolution>0</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>4</ActiveRow>
     <ActiveCol>3</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
