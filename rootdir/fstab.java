# Android fstab file.
# The filesystem that contains the filesystem checker binary (typically /system) cannot
# specify MF_CHECK, and must come before any filesystems that do specify MF_CHECK

#<src>                             <mnt_point>  <type>   <mnt_flags and options>                                                  <fs_mgr_flags>
/dev/block/mmcblk0p19               /system      ext4     ro,noatime                                                              wait
/dev/block/mmcblk0p21               /data        f2fs     rw,nosuid,nodev,noatime,nodiratime,inline_xattr                         wait,check,encryptable=footer,length=-16384
/dev/block/mmcblk0p21               /data        ext4     noatime,nosuid,nodev,noauto_da_alloc,journal_async_commit,errors=panic  wait,check,encryptable=footer,length=-16384
/dev/block/mmcblk0p18               /cache       f2fs     rw,nosuid,nodev,noatime,nodiratime,inline_xattr                         wait,check
/dev/block/mmcblk0p18               /cache       ext4     noatime,nosuid,nodev,journal_async_commit,errors=panic                  wait,check
/dev/block/mmcblk0p17               /efs         ext4     noatime,nosuid,nodev,journal_async_commit,errors=panic                  wait,check

# recovery
/dev/block/mmcblk0p5                /boot        emmc     defaults                                                                defaults
/dev/block/mmcblk0p6                /recovery    emmc     defaults                                                                defaults
/dev/block/mmcblk0p7                /modem       emmc     defaults                                                                defaults

# vold-managed volumes
/devices/platform/sdhci.3/mmc_host* auto         auto     defaults                                                                voldmanaged=sdcard1:auto,encryptable=userdata

# zRAM
/dev/block/zram0                    none         swap     defaults                                                                zramsize=268435456,zramstreams=2
